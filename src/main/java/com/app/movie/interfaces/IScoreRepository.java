/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.movie.interfaces;

import com.app.movie.entities.Movie;
import com.app.movie.entities.Score;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 *
 * @author Andres
 */
public interface IScoreRepository extends MongoRepository<Score, String> {

    @Query(value= "{movie.id : ?0,client.id:?1}") // SQL Equivalent : SELECT * FROM Movie select * from Movie where name=?
    Iterable<Score> getScoreByMovieAndClient(String movieId,String clientId);

}
