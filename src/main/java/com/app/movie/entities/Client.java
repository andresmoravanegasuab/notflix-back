/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.entities;


import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Andres
 */
@Document("client")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private String id;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String birthDate;
    private String phone;
    
    //@OneToMany(cascade={CascadeType.PERSIST},mappedBy="messa<ge")
    //@JsonIgnoreProperties("message")
//    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="client")
//    @JsonIgnoreProperties({"quadbike","client"})
//    private List<Message> messages;
//
//    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="client")
//    @JsonIgnoreProperties("client")
//    private List<Reservation> reservations;
    
    
    
}
