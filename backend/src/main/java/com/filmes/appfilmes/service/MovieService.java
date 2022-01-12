package com.filmes.appfilmes.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filmes.appfilmes.dto.MovieDTO;
import com.filmes.appfilmes.entities.Movie;
import com.filmes.appfilmes.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository resporitory;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll (Pageable pageable) {
		Page<Movie> result = resporitory.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findAllById (Long id) {
		Movie result = resporitory.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
}
