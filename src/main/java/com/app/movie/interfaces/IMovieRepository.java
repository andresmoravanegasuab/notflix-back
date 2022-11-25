/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.movie.interfaces;

import com.app.movie.entities.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres
 */
public interface IMovieRepository extends CrudRepository<Movie, String> {
    
}
