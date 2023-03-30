package com.estiam.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.estiam.demo.entities.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {


}
