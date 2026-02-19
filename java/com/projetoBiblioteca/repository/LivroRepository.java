package com.projetoBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoBiblioteca.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}