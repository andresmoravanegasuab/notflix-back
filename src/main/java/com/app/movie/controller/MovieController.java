/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.controller;

import com.app.movie.dto.ResponseDtimport com.app.movie.entities.Movie;
import com.app.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Movie> getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto>  create(@RequestBody Movie request) {
        ResponseDto responseDto = service.create(request);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto,HttpStatus.CONFLICT);

        if(responseDto.status.booleanValue()==true){
            response = new ResponseEntity<>(responseDto,HttpStatus.CREATED);
        }

        return response;
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
