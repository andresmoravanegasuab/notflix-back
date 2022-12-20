/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.movie.service;

import com.app.movie.dto.ReportCategoryMovies;
import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Category;
import com.app.movie.entities.Movie;
import com.app.movie.interfaces.ICategoryRepository;

import com.app.movie.interfaces.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
@Service
public class CategoryService {

    @Autowired
    ICategoryRepository repository;

    @Autowired
    IMovieRepository movieRepository;

    public Iterable<Category> getByMovies() {
        Iterable<Category> response;

        Iterable<Movie> movies = movieRepository.findAll();
        List<Category> categories = new ArrayList<>();
        for (Movie movie: movies) {
            if(movie.getCategories()!=null){
                for (Category cat:movie.getCategories()) {
                    if(!categories.stream().anyMatch(x->x.getName().equals(cat.getName()))){
                        Category currentCategory= new Category();
                        currentCategory.setName(cat.getName());
                        currentCategory.setDescription(cat.getDescription());
                        currentCategory.setAgeMinimum(cat.getAgeMinimum());
                        categories.add(currentCategory);
                    }
                }
            }
        }

        return categories;
    }

    public Iterable<Category> get() {
        Iterable<Category> categories = repository.findAll();
        return categories;
    }

    public ResponseDto create(Category request) {

        Category newCategory = repository.save(request);

        ResponseDto responseDto = new ResponseDto();
        responseDto.status=true;
        responseDto.message="Categoría creada correctamente";
        responseDto.id= newCategory.getId();
        return responseDto;

    }

    public Category update(Category category) {
        Category categoryToUpdate = new Category();
        if (repository.existsById(category.getId())) {
            categoryToUpdate = category;
            repository.save(categoryToUpdate);
        }
        return categoryToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
