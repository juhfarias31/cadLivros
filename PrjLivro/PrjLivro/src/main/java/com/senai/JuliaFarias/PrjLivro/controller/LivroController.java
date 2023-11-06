package com.senai.JuliaFarias.PrjLivro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.JuliaFarias.PrjLivro.entities.Livro;
import com.senai.JuliaFarias.PrjLivro.services.LivroService;

@RestController
@RequestMapping("/Livro")
public class LivroController {
	private final LivroService livroService;

@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}

@Autowired
	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}

@PostMapping
	public Livro createJogo(@RequestBody Livro livro) {
		return livroService.saveLivro(livro);
	}
		
//Utilizando o ResponseEntity e RequestEntit
@GetMapping
public ResponseEntity<List<Livro>> getAllLivro(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Livro> livro = livroService.getAllLivro();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(livro);
}
		
@PutMapping("/{id}")
	public Livro updateJogo(@PathVariable Long id, @RequestBody Livro livro) {
		return livroService.updateLivro(id, livro);
	}

@GetMapping("/{id}")
public ResponseEntity<Livro> getJogo(@PathVariable Long id) {
	Livro livro = livroService.getLivroById(id);
	if (livro != null) {
		return ResponseEntity.ok(livro);
	} else {
		return ResponseEntity.notFound().build();
	}
}

@DeleteMapping("/{id}")
public void deleteLivro(@PathVariable Long id) {
		livroService.deletLivro(id);
	}
}