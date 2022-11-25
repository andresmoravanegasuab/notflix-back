/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.entities;


import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Andres
 */
@Document("category")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    
    //@OneToMany(cascade={CascadeType.PERSIST},mappedBy="category")
    //@JsonIgnoreProperties("category")
    //private List<Quadbike> quadbikes;
    
    
    
    
    
}
