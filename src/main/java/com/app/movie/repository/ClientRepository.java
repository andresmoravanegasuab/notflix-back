/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.repository;

import com.app.movie.entities.Client;
import com.app.movie.interfaces.IClientRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andres
 */
@Repository
public class ClientRepository {
    
    @Autowired
    IClientRepository repository;
    
    public Iterable<Client> getAll(){
        return repository.findAll();
    }
    
    public Optional<Client> findById(String id){
        Optional<Client> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(String id){
        return repository.existsById(id);
    }
    
    public void deleteById(String id){
        repository.deleteById(id);
    }
    
    public Client save(Client client){
        return repository.save(client);
    }
    
}
