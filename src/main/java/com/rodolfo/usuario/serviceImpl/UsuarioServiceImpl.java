package com.rodolfo.usuario.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfo.usuario.dtos.UsuarioDto;
import com.rodolfo.usuario.entitys.Usuario;
import com.rodolfo.usuario.mappers.UsuarioMapper;
import com.rodolfo.usuario.repository.UsuarioRepository;
import com.rodolfo.usuario.service.UsuarioService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioDto> recuperarUsuarios() {
		
		List<Usuario> listaUsuarios = usuarioRepository.findAll();
		
		List<UsuarioDto> listaUsuariosDto = listaUsuarios.stream().map(
				usuario -> UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario)).toList();
		/*
		return listaUsuarios.parallelStream().map(user ->{
			UsuarioDto usuario = new UsuarioDto();
			usuario.setId(user.getId());
			usuario.setEdad(user.getEdad());
			usuario.setEmail(user.getEmail());
			return usuario;
		}).toList();*/
		return listaUsuariosDto;
	}

	@Override
	public UsuarioDto recuperarPorId(Long id) {
		Usuario usuarioEncontrado = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontro el id usuario "+id));
		 return UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuarioEncontrado);
	}

	@Override
	@Transactional
	public void guardar(UsuarioDto usuario) {
		usuarioRepository.save(UsuarioMapper.INSTANCE.usuarioDtoToUsuario(usuario));	
	}

}
