/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.service;

import com.app.movie.dto.AuthDto;
import com.app.movie.dto.AuthResponseDto;
import com.app.movie.dto.ReportClientDto;
import com.app.movie.entities.Client;
import com.app.movie.repository.ClientRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Andres
 */
@Service
public class AuthService {

    @Autowired
    ClientRepository repository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthResponseDto check(AuthDto request) {
        Optional<Client> client = checkCredential(request.user,request.password);
        AuthResponseDto response = new AuthResponseDto();
        if(client !=null && client.isPresent()){
            response.id=client.get().getId();
            response.name=client.get().getName()+" "+client.get().getLastName();
            response.email=client.get().getEmail();
            response.token=getToken(client.get());
        }
        return response;
    }

    private String getToken(Client client){
        return "";
    }

    public Optional<Client> checkCredential(String user,String password) {

        Optional<Client> client = repository.findByEmail(user);
        if(!matchPass(password,client.get().getPassword())){
            return null;
        }
        return client;
    }

    public Optional<Client> getByCredential(String credential) {
        String pair = new String(Base64.decodeBase64(credential.substring(6)));
        String email = pair.split(":")[0];
        String pass = pair.split(":")[1];

        Optional<Client> client = repository.findByEmail(email);
        if(!matchPass(pass,client.get().getPassword())){
            return null;
        }
        return client;
    }

    private Boolean matchPass(String pass,String dbPass){
        return this.passwordEncoder.matches(pass,dbPass);
    }
}
