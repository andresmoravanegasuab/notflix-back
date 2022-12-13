/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.controller;

import com.app.movie.dto.ResponseDto;
import com.app.movie.dto.ScoreDto;
import com.app.movie.entities.Movie;
import com.app.movie.entities.Score;
import com.app.movie.service.MovieService;
import com.app.movie.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/score")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    ScoreService service;

    @GetMapping("")
    public Iterable<Score> get() {
        return service.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto create(@RequestBody ScoreDto request,@RequestHeader(value="authorization") String authorization) {
        return service.create(request,authorization);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Score update(@RequestBody Score request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}
