package com.app.movie.dto;

import com.app.movie.entities.Category;
import com.app.movie.service.MovieService;

import java.util.List;

public class ReportCategoryMovies {
    Category category;
    List<MovieService> moviesList;
}
