package com.rodolfo.usuario.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

	private Long id;
	

	private String nombre;
	

	private Integer edad;
	
	
	private String email;
}
