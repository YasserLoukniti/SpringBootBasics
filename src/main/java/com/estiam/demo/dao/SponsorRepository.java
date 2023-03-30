package com.estiam.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estiam.demo.entities.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor, Long>{

}
