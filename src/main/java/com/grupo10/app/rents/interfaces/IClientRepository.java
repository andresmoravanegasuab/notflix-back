/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo10.app.rents.interfaces;

import com.grupo10.app.rents.entities.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres
 */
public interface IClientRepository extends CrudRepository<Client, String> {
    
}
