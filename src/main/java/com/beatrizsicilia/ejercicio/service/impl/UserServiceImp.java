package com.beatrizsicilia.ejercicio.service.impl;

import com.beatrizsicilia.ejercicio.join.UserDocumentJoin;
import com.beatrizsicilia.ejercicio.model.UserModel;
import com.beatrizsicilia.ejercicio.repository.UserRepository;
import com.beatrizsicilia.ejercicio.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository repository; 

    @Override
    public Iterable<UserModel> retrieveAll(){
        return repository.findAll(); 
    }
    
    @Autowired
    private JdbcTemplate template;
    
    @Override
    public Iterable<UserDocumentJoin> retrieveUserDocumentJoin(){
        String query = "SELECT * FROM USERS INNER JOIN DOCUMENTS ON USERS.USER_ID = DOCUMENTS.USER_ID"; 

        Iterable<UserDocumentJoin> resultado = template.query(query,
        (data, rowNum) -> {
            return new UserDocumentJoin(
                data.getLong("USERS.USER_ID"),
                data.getString("USERS.USER"),
                data.getString("USERS.COMMENT"),
                data.getLong("DOCUMENTS.DOC_ID"),
                data.getString("DOCUMENTS.DOC")
            );
        }
    );

    return resultado; 

    }
    
}
