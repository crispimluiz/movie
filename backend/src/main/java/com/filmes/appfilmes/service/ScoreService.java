package com.filmes.appfilmes.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filmes.appfilmes.dto.MovieDTO;
import com.filmes.appfilmes.dto.ScoreDTO;
import com.filmes.appfilmes.entities.Movie;
import com.filmes.appfilmes.entities.Score;
import com.filmes.appfilmes.entities.User;
import com.filmes.appfilmes.repositories.MovieRepository;
import com.filmes.appfilmes.repositories.ScoreRepository;
import com.filmes.appfilmes.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieResporitory;
	
	@Autowired
	private UserRepository userResporitory;
	
	@Autowired
	private ScoreRepository scoreResporitory;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userResporitory.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userResporitory.saveAndFlush(user);
		}
		
		Movie movie = movieResporitory.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.SetMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreResporitory.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie  = movieResporitory.save(movie);
		
		return new MovieDTO(movie);
	}
	
}
