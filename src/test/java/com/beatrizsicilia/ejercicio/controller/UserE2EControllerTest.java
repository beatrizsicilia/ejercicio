package com.beatrizsicilia.ejercicio.controller;

import com.beatrizsicilia.ejercicio.join.UserDocumentJoin;
import com.beatrizsicilia.ejercicio.model.UserModel;
import com.beatrizsicilia.ejercicio.repository.UserRepository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.jdbc.core.JdbcTemplate;
import static org.assertj.core.api.BDDAssertions.then;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserE2EControllerTest {
    
    @Autowired 
    UserRepository repository; 
    @Autowired 
    TestRestTemplate testRestTemplate; 
    @LocalServerPort 
    private int port; 
    
    @Test
    public void usersEndpointTest(){

        //lo que espero obtener
        Iterable<UserModel> users = repository.findAll(); 

        //simulo llamada
        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users"; 
        HttpHeaders headers = new HttpHeaders();  
        HttpEntity<String> entity = new HttpEntity<>(headers);

        //llamada
        ResponseEntity<Iterable<UserModel>> result = testRestTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<UserModel>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(users);   
        
    }

    @Autowired
    private JdbcTemplate template;

    @Test
    public void usersJoinEndpoinTest() {
        String query = "SELECT * FROM USERS INNER JOIN DOCUMENTS ON USERS.USER_ID = DOCUMENTS.USER_ID";

        Iterable<UserDocumentJoin> userDocumentJoins = template.query(
            query,
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

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users/join";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<UserDocumentJoin>> result = testRestTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<UserDocumentJoin>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(userDocumentJoins);
    }
   

   


   
}
