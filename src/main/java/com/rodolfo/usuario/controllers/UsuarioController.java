package com.rodolfo.usuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfo.usuario.dtos.UsuarioDto;
import com.rodolfo.usuario.service.UsuarioService;

@RestController
@RequestMapping("/api")

public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping("/guardar")
	public ResponseEntity<UsuarioDto> guardar(@RequestBody UsuarioDto usuario){
		usuarioService.guardar(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
	
	@GetMapping("/recuperarPorId/{id}")
	public ResponseEntity<UsuarioDto> recuperaPorId(@PathVariable Long id) {
		
		return ResponseEntity.status(HttpStatus.FOUND).body(usuarioService.recuperarPorId(id));
	}
	
	@GetMapping("/recuperarTodo")
	public ResponseEntity<List<UsuarioDto>> recuperaTodosUsuarios(){
		return ResponseEntity.ok(usuarioService.recuperarUsuarios());
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<UsuarioDto> actualizausuario(@PathVariable Long id, @RequestBody UsuarioDto usuario){
		
		return ResponseEntity.ok(usuarioService.actualizarUsuario(id, usuario));
	}
	

}
