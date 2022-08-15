package com.bootcamp.java.spp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.java.spp.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}