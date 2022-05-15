package com.beatrizsicilia.ejercicio.repository;

import com.beatrizsicilia.ejercicio.model.UserModel;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long>  {
    
}
