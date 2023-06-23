package com.tcc.petPlusBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.petPlusBackEnd.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{

}
