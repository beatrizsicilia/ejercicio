package com.beatrizsicilia.ejercicio.repository;

import com.beatrizsicilia.ejercicio.model.DocumentModel;

import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<DocumentModel, Long>{
    
}
