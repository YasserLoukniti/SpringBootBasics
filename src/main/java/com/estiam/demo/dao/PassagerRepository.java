package com.estiam.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estiam.demo.entities.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Long>{

}
