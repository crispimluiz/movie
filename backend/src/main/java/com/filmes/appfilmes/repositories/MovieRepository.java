package com.filmes.appfilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmes.appfilmes.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
