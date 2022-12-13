/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.controller;

import com.app.movie.dto.AuthDto;
import com.app.movie.dto.AuthResponseDto;
import com.app.movie.dto.ReportClientDto;
import com.app.movie.entities.Client;
import com.app.movie.service.AuthService;
import com.app.movie.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AuthResponseDto check(@RequestBody AuthDto request) {
        return service.check(request);
    }

}
