package com.beatrizsicilia.ejercicio.service;

import com.beatrizsicilia.ejercicio.join.UserDocumentJoin;
import com.beatrizsicilia.ejercicio.model.UserModel;

public interface UserService {
    Iterable<UserModel> retrieveAll(); 
    Iterable<UserDocumentJoin> retrieveUserDocumentJoin(); 
}
