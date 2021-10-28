package com.caffeapi.aplication.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caffeapi.aplication.entity.Perfil;
import com.caffeapi.aplication.repository.PerfilRepository;
import com.caffeapi.aplication.validators.PerfilValidator;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepo;

	public Perfil findById(Integer perfilId) {
		Perfil objPerfil = perfilRepo.findById(perfilId)
				.orElseThrow(() -> new RuntimeException("No existe el perfil."));
		return objPerfil;
	}
	
	public List<Perfil> findAll() {
		List<Perfil> perfiles = perfilRepo.findAll();
		return perfiles;
	}

	@Transactional
	public void delete(Integer perfilId) {
		Perfil objPerfil = perfilRepo.findById(perfilId)
				.orElseThrow(() -> new RuntimeException("No existe el perfil."));

		perfilRepo.delete(objPerfil);
	}	

	@Transactional
	public Perfil create(Perfil perfil) {
		PerfilValidator.save(perfil);		
		Perfil nuevoPerfil = perfilRepo.save(perfil);
		return nuevoPerfil;
	}

	@Transactional
	public Perfil update(Perfil perfil) {
		Perfil existePerfil = perfilRepo.findById(perfil.getPerfilId())
				.orElseThrow(() -> new RuntimeException("No existe el perfil."));
		
		existePerfil.setNombre(perfil.getNombre());
		perfilRepo.save(existePerfil);
		return existePerfil;
	}
}
