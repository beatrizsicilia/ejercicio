package com.beatrizsicilia.ejercicio.controller;

import com.beatrizsicilia.ejercicio.join.UserDocumentJoin;
import com.beatrizsicilia.ejercicio.model.UserModel;
import com.beatrizsicilia.ejercicio.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")

public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserModel>> retrieveAll(){
        return ResponseEntity.ok().body(service.retrieveAll());
    }

    @GetMapping("/users/join")
    public ResponseEntity<Iterable<UserDocumentJoin>> retrieveUserDocumentJoin(){
        return ResponseEntity.ok().body(service.retrieveUserDocumentJoin()); 
    }
    
}
