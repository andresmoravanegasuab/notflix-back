/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.service;

import com.app.movie.dto.ResponseDto;
import com.app.movie.dto.ScoreDto;
import com.app.movie.entities.Client;
import com.app.movie.entities.Movie;
import com.app.movie.entities.Score;
import com.app.movie.repository.ClientRepository;
import com.app.movie.repository.MovieRepository;
import com.app.movie.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 * @author Andres
 */
@Service
public class ScoreService {

    @Autowired
    ScoreRepository repository;


    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ClientRepository clientRepository;

    public Iterable<Score> get() {
        Iterable<Score> response = repository.getAll();
        return response;
    }

    public ResponseDto create(ScoreDto request) {
        ResponseDto response = new ResponseDto();
        if(request.score<0 || request.score>10){
            response.status=false;
            response.message="La calificación enviada no está dentro de los valores esperados";
        }else{
            Score score = new Score();

            Optional<Movie> movie = movieRepository.findById(request.movieId);
            Optional<Client> client = clientRepository.findById(request.clientId);
            if(movie.isPresent()){
                //score.setMovie(movie);
                //score.setClient(client);
                repository.save(score);
                response.status=true;
                response.message="Calificación guardada correctamente";
                response.id= score.getId();
            }


        }
        return response;
    }

    public Score update(Score score) {
        Score scoreToUpdate = new Score();

        Optional<Score> currentScore = repository.findById(score.getId());
        if (!currentScore.isEmpty()) {
            scoreToUpdate = score;
            scoreToUpdate=repository.save(scoreToUpdate);
        }
        return scoreToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
