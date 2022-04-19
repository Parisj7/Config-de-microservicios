package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
	private MovieRepository movieRepository;

	@Autowired
	public CatalogServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public CatalogWS getMoviesByGenre(String genre) {
		List<MovieWS> moviesByGenre = movieRepository.getMoviesByGenre(genre);
		return CatalogWS.builder()
				.genre(genre)
				.movies(moviesByGenre)
				.build();
	}
}
