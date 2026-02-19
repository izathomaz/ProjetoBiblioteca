package com.projetoBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoBiblioteca.entity.Livro;
import com.projetoBiblioteca.repository.LivroRepository;

@Service
public class LivroService {
	
	final private LivroRepository livroRepository;

	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public List<Livro> buscarTodosLivros(){
		return livroRepository.findAll();
	}
	
	public Livro buscarLivrosPorId(Long id){
		  Optional <Livro> livro = livroRepository.findById(id);
	        return livro.orElse(null);
	}
	
	public Livro salvarLivros(Livro atLivro) {
		return livroRepository.save(atLivro);
	}
	
	public Livro atualizarLivro(Long id, Livro atLivro) {
		Optional <Livro> exeLivro = livroRepository.findById(id);
		if(exeLivro.isPresent()) {
			atLivro.setId(id);
			return livroRepository.save(atLivro);
		}
		else {
			return null;
		}
	}
	
	public Boolean apagarLivro(Long id) {
		Optional<Livro> exeLivro = livroRepository.findById(id);
		if(exeLivro.isPresent()) {
			livroRepository.deleteById(id);
			return true;
		}
		return false;
	}
	

}
