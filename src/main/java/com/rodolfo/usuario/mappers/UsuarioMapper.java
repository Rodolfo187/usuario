package com.rodolfo.usuario.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rodolfo.usuario.dtos.UsuarioDto;
import com.rodolfo.usuario.entitys.Usuario;

@Mapper
public interface UsuarioMapper {

	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
	
	UsuarioDto usuarioToUsuarioDTO(Usuario usuario);
	
	Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
}
