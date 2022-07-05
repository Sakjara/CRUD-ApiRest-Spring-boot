package com.example.prueba1.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.prueba1.models.PersonajeModel;
import com.example.prueba1.repositories.PersonajeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;

    public ArrayList<PersonajeModel> obtenerPersonajes(){
        return (ArrayList<PersonajeModel>) personajeRepository.findAll();
    }

    public PersonajeModel guardarPersonaje(PersonajeModel personaje){
        return personajeRepository.save(personaje);
    }

    public Optional<PersonajeModel> obtenerPorId(Long id){
        return personajeRepository.findById(id);
    }

    public boolean eliminarPersonaje(Long id) {
        try{
            personajeRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}
