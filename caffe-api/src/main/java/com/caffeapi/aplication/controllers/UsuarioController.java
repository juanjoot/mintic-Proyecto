package com.caffeapi.aplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caffeapi.aplication.entity.Usuarios;
import com.caffeapi.aplication.services.UsuariosService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;



@RestController
public class UsuarioController {

	@Autowired
	private UsuariosService UsuarioServicio;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/usuarios/{idUsuario}")
	public ResponseEntity<Usuarios> findById(@PathVariable("idUsuario") Integer idUsuario) {
		Usuarios objUsuario = UsuarioServicio.findById(idUsuario);			
		return new ResponseEntity<Usuarios>(objUsuario, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/usuarios/{idUsuario}")
	public ResponseEntity<Void> delete(@PathVariable("idUsuario") Integer idUsuario) {
		UsuarioServicio.delete(idUsuario);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping(value = "/usuarios")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Usuarios>> findAll() {
		List<Usuarios> Usuariosall = UsuarioServicio.findAll();
		return new ResponseEntity<List<Usuarios>>(Usuariosall, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/usuarios")
	public ResponseEntity<Usuarios> create(@RequestBody Usuarios Usuario) {
		Usuarios nuevoUsuario = UsuarioServicio.create(Usuario);
		return new ResponseEntity<Usuarios>(nuevoUsuario, HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(value = "/usuarios")
	public ResponseEntity<Usuarios> update(@RequestBody Usuarios Usuario) {
		Usuarios existeUsuario = UsuarioServicio.update(Usuario);		
		return new ResponseEntity<Usuarios>(existeUsuario, HttpStatus.OK);
	}
}
