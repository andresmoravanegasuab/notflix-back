/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.movie.interfaces;

import com.app.movie.entities.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres
 */
public interface ICategoryRepository extends CrudRepository<Category, String> {
    
}
