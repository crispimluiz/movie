package com.filmes.appfilmes.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmes.appfilmes.dto.MovieDTO;
import com.filmes.appfilmes.dto.ScoreDTO;
import com.filmes.appfilmes.service.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService service;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto){
		
		MovieDTO MovieDTO = service.saveScore(dto);
		return MovieDTO;
	}
}
