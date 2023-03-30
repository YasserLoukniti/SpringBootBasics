package com.estiam.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estiam.demo.dao.PassagerRepository;
import com.estiam.demo.dao.VoitureRepository;
import com.estiam.demo.entities.Passager;
import com.estiam.demo.entities.Voiture;

@RestController
@RequestMapping("/voitures")
public class VoitureController {
    @Autowired
    private VoitureRepository vr;
	@Autowired
	private PassagerRepository pr; 
    
    @GetMapping("")
    public List<Voiture> getAllVoitures() {
        return vr.findAll();
    }
    
    
    @GetMapping("/{id}")
    public Voiture getVoitureById(@PathVariable Long id) throws NotFoundException {
        return vr.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }
    
  
    
    @PostMapping("")
    public Voiture createVoiture(@RequestBody Voiture voiture) {
		System.out.println("Successsss");
        return vr.save(voiture);
    }
    
    @PostMapping("/create-with-passagers/{nbPassagers}")
    public Voiture createVoitureWithPassagers(@PathVariable int nbPassagers,@RequestBody Voiture voiture) {

		List<Passager> passagers = new ArrayList<Passager>();
		for (int i = 1; i <= nbPassagers; i++) {
			passagers.add(new Passager("Passager "+i,i+12));

		}
		pr.saveAll(passagers);
		voiture.setPassagers(passagers);
        return vr.save(voiture);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable Long id, @RequestBody Voiture voitureDetails) throws Exception {
        Voiture voiture = vr.findById(id)
                .orElseThrow(() -> new NotFoundException());
        voiture.setName(voitureDetails.getName());
        voiture.setColor(voitureDetails.getColor());
        final Voiture updatedVoiture = vr.save(voiture);
        return ResponseEntity.ok(updatedVoiture);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable(value = "id") Long voitureId) {
        vr.deleteById(voitureId);
        return ResponseEntity.noContent().build();
    }

}
