package com.filmes.appfilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmes.appfilmes.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
