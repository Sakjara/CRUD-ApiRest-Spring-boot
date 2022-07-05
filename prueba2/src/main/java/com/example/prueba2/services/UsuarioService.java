package com.example.prueba2.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.prueba2.models.UsuarioModel;
import com.example.prueba2.repositories.UsuarioRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public UsuarioModel actualizarUsuario(UsuarioModel usuario, Long id){
        return usuarioRepository.save(usuario);
    }

    public ArrayList<UsuarioModel> findByGender(String gender){
        if(gender != null){
            return usuarioRepository.findByGender(gender);
        }
        return null;
    }

    public ArrayList<UsuarioModel> findByAge(Integer age){
        if(age != null){
            return usuarioRepository.findByAge(age);
        }
        return null;
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
