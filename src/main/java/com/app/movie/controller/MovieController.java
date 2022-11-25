/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.controller;

import com.app.movie.entities.Client;
import com.app.movie.entities.Movie;
import com.app.movie.service.ClientService;
import com.app.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    MovieService service;

    @GetMapping("")
    public Iterable<Movie> get() {
        return service.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie create(@RequestBody Movie request) {
        return service.create(request);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Movie update(@RequestBody Movie request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}
