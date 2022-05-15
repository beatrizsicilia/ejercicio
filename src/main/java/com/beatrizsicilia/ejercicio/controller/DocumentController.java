package com.beatrizsicilia.ejercicio.controller;

import com.beatrizsicilia.ejercicio.model.DocumentModel;
import com.beatrizsicilia.ejercicio.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class DocumentController {
    @Autowired  
    private DocumentService service; 

    @GetMapping("/documents")
    public ResponseEntity<Iterable<DocumentModel>> retrieveAll(){
        return ResponseEntity.ok().body(service.retrieveAll()); 
    }
}
