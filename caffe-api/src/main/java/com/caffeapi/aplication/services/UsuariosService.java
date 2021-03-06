package com.caffeapi.aplication.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caffeapi.aplication.entity.Usuarios;
import com.caffeapi.aplication.repository.UsuariosRepository;
import com.caffeapi.aplication.validators.UsuariosValidator;

@Service
public class UsuariosService {

	
	@Autowired
	private UsuariosRepository UsuarioRepositorio;
	
	public Usuarios findById(Integer idUsuario) {
		Usuarios objUsuario = UsuarioRepositorio.findById(idUsuario)
				.orElseThrow(()-> new RuntimeException("No Existe el usuario"));
		return objUsuario;
	}
	
	public List<Usuarios> findAll() {
		List<Usuarios> Usuariosall = UsuarioRepositorio.findAll();
		return Usuariosall;
	}
	
	@Transactional
	public void delete(Integer idUsuario) {
		Usuarios objUsuario = UsuarioRepositorio.findById(idUsuario)
				.orElseThrow(()-> new RuntimeException("No Existe el usuario"));
		
		UsuarioRepositorio.delete(objUsuario);
		
	}	
	
	@Transactional
	public Usuarios create(Usuarios Usuario) {
		UsuariosValidator.save(Usuario);		
		Usuarios nuevoUsuario = UsuarioRepositorio.save(Usuario);
		return nuevoUsuario;
	}
	
	@Transactional
	public Usuarios update(Usuarios Usuario) {
		Usuarios existeUsuario = UsuarioRepositorio.findById(Usuario.getIdUsuario())
				.orElseThrow(()-> new RuntimeException("No Existe el usuario"));
		
		existeUsuario.setNombreUsuario(Usuario.getNombreUsuario());
		existeUsuario.setApellidoUsuario(Usuario.getApellidoUsuario());
		existeUsuario.setGeneroUsuario(Usuario.getGeneroUsuario());
		existeUsuario.setFechaNacimiento(Usuario.getFechaNacimiento());
		existeUsuario.setNumeroTel(Usuario.getNumeroTel());
		existeUsuario.setCorreoUsuario(Usuario.getCorreoUsuario());
		existeUsuario.setContrasenaUsuario(Usuario.getContrasenaUsuario());
		existeUsuario.setNumeroDocumento(Usuario.getNumeroDocumento());
		existeUsuario.setTipodocumento(Usuario.getTipodocumento());
		existeUsuario.setPerfil(Usuario.getPerfil());
		
		UsuarioRepositorio.save(existeUsuario);
		return existeUsuario;
	}
}
