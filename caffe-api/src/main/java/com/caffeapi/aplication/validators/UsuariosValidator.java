package com.caffeapi.aplication.validators;

import com.caffeapi.aplication.entity.Usuarios;

public class UsuariosValidator {

	
public static void save (Usuarios usuario) {
		
		if (usuario.getNombreUsuario() == null || usuario.getNombreUsuario().trim().isEmpty() ) {
			
			throw new RuntimeException("el nombre de usuario es requerido");
		}
		
		if (usuario.getNombreUsuario().length() > 100 ) {
			
			throw new RuntimeException("el nombre de usuario no puede exceder los 100 caracteres");
		}
		
		if (usuario.getContrasenaUsuario() == null || usuario.getContrasenaUsuario().trim().isEmpty() ) {
			
			throw new RuntimeException("la contrasena de usuario es requerido");
		}
		
		if (usuario.getContrasenaUsuario().length() > 20 ) {
			
			throw new RuntimeException("la contrasena no puede exceder los 20 caracteres");
		}
		
		if (usuario.getCorreoUsuario() == null || usuario.getCorreoUsuario().trim().isEmpty() ) {
			
			throw new RuntimeException("el correo de usuario es requerido");
		}
		
		if (usuario.getCorreoUsuario().length() > 40 ) {
			
			throw new RuntimeException("el correo de usuario no puede exceder los 40 caracteres");
		}
		
		if (usuario.getFechaNacimiento() == null || usuario.getFechaNacimiento().trim().isEmpty() ) {
			
			throw new RuntimeException("la fecha de nacimiento es requerido");
		}
		
		if (usuario.getNumeroDocumento() == null || usuario.getNumeroDocumento().trim().isEmpty() ) {
			
			throw new RuntimeException("el numero de documento es requerido");
		}
		
		if (usuario.getNumeroDocumento().length() > 20 ) {
			
			throw new RuntimeException("el numero de documento no puede exceder los 20 caracteres");
		}
		
		
	}
}
