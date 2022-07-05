package com.example.prueba1.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;

import com.example.prueba1.models.PersonajeModel;
import com.example.prueba1.services.PersonajeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PersonajeController {
    @Autowired
    PersonajeService personajeService;

    @GetMapping("/personajes")
    public ArrayList<PersonajeModel> obtenerPersonajes() {
        return this.personajeService.obtenerPersonajes();
    }

    @PostMapping("/guardar")
    public ResponseEntity<PersonajeModel> guardarPersonaje(@RequestBody PersonajeModel personaje) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("https://rickandmortyapi.com/api/character").toString());
        return ResponseEntity.created(uri).body(personajeService.guardarPersonaje(personaje));

    }

    @GetMapping(path = "/personajes/{id}")
    public Optional<PersonajeModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.personajeService.obtenerPorId(id);
    }

    @DeleteMapping(path = "{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.personajeService.eliminarPersonaje(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}