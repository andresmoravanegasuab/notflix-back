/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.repository;

import com.app.movie.entities.Client;
import com.app.movie.entities.Movie;
import com.app.movie.interfaces.IClientRepository;
import com.app.movie.interfaces.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author Andres
 */
@Repository
public class MovieRepository {
    
    @Autowired
    IMovieRepository repository;
    
    public Iterable<Movie> getAll(){
        return repository.findAll();
    }
    
    public Optional<Movie> findById(String id){
        Optional<Movie> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(String id){
        return repository.existsById(id);
    }
    
    public void deleteById(String id){
        repository.deleteById(id);
    }
    
    public Movie save(Movie movie){
        return repository.save(movie);
    }
    
}
