package com.projetoBiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoBiblioteca.entity.Livro;
import com.projetoBiblioteca.services.LivroService;


@RestController
@RequestMapping ("/livro")
public class LivroController {
	
	@Autowired
    private LivroService livroService;

    public LivroController(LivroService produtoService) {
        this.livroService = produtoService;
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroId(@PathVariable Long id) {
        Livro livro = livroService.buscarLivrosPorId(id);
        if (livro != null) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Livro>> buscarTodosLivro() {
        List<Livro> produtos = livroService.buscarTodosLivros();
        return ResponseEntity.ok(produtos);
    }

 
    @PostMapping("/")
    public ResponseEntity<Livro> salvaProduto(@RequestBody Livro livros) {
        Livro saveLivros = livroService.salvarLivros(livros);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveLivros);
    }
    
 
    @PutMapping("/{id}")
    public ResponseEntity<Livro> alteraProdutos(@PathVariable Long id, @RequestBody Livro livro) {
        Livro atualizaLivro = livroService.atualizarLivro(id, livro);
        if (atualizaLivro != null) {
            return ResponseEntity.ok(atualizaLivro); // Retorna o produto atualizado
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
        }
    }
    
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Livro> apagaLivro(@PathVariable Long id) {
        boolean apagaLivro = livroService.apagarLivro(id);
        if (apagaLivro) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
        }
    }
}

