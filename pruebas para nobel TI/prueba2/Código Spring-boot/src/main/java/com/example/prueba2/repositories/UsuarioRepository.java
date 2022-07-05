package com.example.prueba2.repositories;

import java.util.ArrayList;

import com.example.prueba2.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findByAge(Integer age);
    public abstract ArrayList<UsuarioModel> findByGender(String gender);

}
