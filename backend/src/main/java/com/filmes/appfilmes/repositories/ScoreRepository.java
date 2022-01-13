package com.filmes.appfilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmes.appfilmes.entities.Score;
import com.filmes.appfilmes.entities.ScorePk;

public interface ScoreRepository extends JpaRepository<Score, ScorePk>{

}
