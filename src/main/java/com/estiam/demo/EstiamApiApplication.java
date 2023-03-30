package com.estiam.demo;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.estiam.demo.dao.PassagerRepository;
import com.estiam.demo.dao.SponsorRepository;
import com.estiam.demo.dao.VoitureRepository;
import com.estiam.demo.entities.Passager;
import com.estiam.demo.entities.Sponsor;
import com.estiam.demo.entities.Voiture;

@SpringBootApplication
public class EstiamApiApplication implements CommandLineRunner {
	
	@Autowired
	private VoitureRepository vr; 
	@Autowired
	private SponsorRepository sr; 
	@Autowired
	private PassagerRepository pr; 

	public static void main(String[] args) {
		SpringApplication.run(EstiamApiApplication.class, args);
		System.out.println("Test");
	}
	public static String randomStringSimple(int length) {
	    byte[] byteArray = new byte[length];
	    Random random = new Random();
	    random.nextBytes(byteArray);
	 
	    return new String(byteArray, Charset.forName("UTF-8"));
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/**
		 *
		 
		Voiture tesla= new Voiture("Tesla",23,"black",true);
		vr.save(tesla);
		List<Passager> passagers = new ArrayList<Passager>() ;
		for (int i = 0; i < 20; i++) {
			passagers.add(new Passager("Passager "+i,i+10));

		}
		pr.saveAll(passagers);
		tesla.setPassagers(passagers);
		System.out.print(tesla.getPassagers());

		vr.save(tesla);
		List<Voiture> voitures = vr.findAll();
		for (Voiture voiture : voitures) {
			System.out.println("ID : "+voiture.getId()+" Name : "+voiture.getName()+" Price : "+voiture.getPrice()+" Color : "+voiture.getColor());
			System.out.print("Passagers : ");
			
			System.out.print(voiture.getPassagers());

			for (Passager passager : voiture.getPassagers()) {
				System.out.println("ID : "+passager.getId()+" Name : "+passager.getName()+" Age : "+passager.getAge());
			}
		}
		*/
		List<Voiture> voitures = new ArrayList<Voiture>();
		
		voitures.add(new Voiture("Tesla 2023",23,"black",true));
		voitures.add(new Voiture("benz 2000",23,"blue",true));

		vr.saveAll(voitures);
		
		Sponsor pepsi = new Sponsor("Pespsi");
		pepsi.setVoitures(voitures);
		sr.save(pepsi);
		
		System.out.println("Success");
	}

}
