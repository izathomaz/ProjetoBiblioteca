package com.projetoBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoBiblioteca.entity.Usuario;
import com.projetoBiblioteca.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> buscarTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarUsuarioPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}

	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario atualizarUsuario(Long id, Usuario usuario) {
		Optional<Usuario> existente = usuarioRepository.findById(id);
		if (existente.isPresent()) {
			usuario.setId(id);
			return usuarioRepository.save(usuario);
		}
		return null;
	}

	public boolean apagarUsuario(Long id) {
		Optional<Usuario> existente = usuarioRepository.findById(id);
		if (existente.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}