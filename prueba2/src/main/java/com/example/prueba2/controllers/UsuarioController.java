package com.example.prueba2.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.prueba2.models.UsuarioModel;
import com.example.prueba2.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/prueba2")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/getUsers")
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping( path = "/getUsers/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping( path = "/getUsers/")
    public ArrayList<UsuarioModel> FiltrarPorEdad(@RequestParam("age") Integer age){
        return this.usuarioService.findByAge(age);
    }

    @GetMapping( path = "/getUsersby/")
    public ArrayList<UsuarioModel> FiltrarPorGenero(@RequestParam("gender") String gender){
        return this.usuarioService.findByGender(gender);
    }

    @PutMapping("{id}")
    public UsuarioModel actualizarUsuario(@RequestBody UsuarioModel usuario, Long id){
        return this.usuarioService.actualizarUsuario(usuario, id);
    }


    @DeleteMapping( path = "{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}