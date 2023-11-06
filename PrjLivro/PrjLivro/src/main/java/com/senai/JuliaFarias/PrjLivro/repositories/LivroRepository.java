package com.senai.JuliaFarias.PrjLivro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.JuliaFarias.PrjLivro.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}