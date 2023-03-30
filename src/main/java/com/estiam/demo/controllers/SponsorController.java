package com.estiam.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estiam.demo.dao.SponsorRepository;
import com.estiam.demo.entities.Sponsor;

@RestController
@RequestMapping("/sponsor")
public class SponsorController {

	@Autowired
	private SponsorRepository sr; 
    
    @GetMapping("")
    public List<Sponsor> getAllSponsors() {
        return sr.findAll();
    }
}
