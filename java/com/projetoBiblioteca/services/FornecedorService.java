package com.projetoBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoBiblioteca.entity.Fornecedor;
import com.projetoBiblioteca.repository.FornecedorRepository;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<Fornecedor> buscarTodosFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor buscarFornecedorPorId(Long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        return fornecedor.orElse(null);
    }

    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor atualizarFornecedor(Long id, Fornecedor fornecedor) {
        Optional<Fornecedor> existente = fornecedorRepository.findById(id);
        if (existente.isPresent()) {
            fornecedor.setId(id);
            return fornecedorRepository.save(fornecedor);
        }
        return null;
    }

    public boolean apagarFornecedor(Long id) {
        Optional<Fornecedor> existente = fornecedorRepository.findById(id);
        if (existente.isPresent()) {
            fornecedorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}