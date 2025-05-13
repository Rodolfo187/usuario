package com.rodolfo.usuario.service;

import java.util.List;

import com.rodolfo.usuario.dtos.UsuarioDto;

public interface UsuarioService {
	
	List<UsuarioDto> recuperarUsuarios();
	
	UsuarioDto recuperarPorId(Long id);
	
	void guardar(UsuarioDto usuario);

}
