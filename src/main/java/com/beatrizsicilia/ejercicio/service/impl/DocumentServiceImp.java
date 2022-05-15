package com.beatrizsicilia.ejercicio.service.impl;

import com.beatrizsicilia.ejercicio.model.DocumentModel;
import com.beatrizsicilia.ejercicio.repository.DocumentRepository;
import com.beatrizsicilia.ejercicio.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImp implements DocumentService{
    @Autowired
    DocumentRepository repository; 
    
    @Override
    public Iterable<DocumentModel> retrieveAll(){
        return repository.findAll();
    }

}
