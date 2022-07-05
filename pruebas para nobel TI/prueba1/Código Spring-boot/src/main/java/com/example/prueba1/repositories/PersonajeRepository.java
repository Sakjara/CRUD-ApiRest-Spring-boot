package com.example.prueba1.repositories;

import com.example.prueba1.models.PersonajeModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends CrudRepository<PersonajeModel, Long> {

}