package com.caffeapi.aplication.services;

import java.util.List;

import javax.transaction.Transactional;

import com.caffeapi.aplication.entity.TipoDocumento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caffeapi.aplication.repository.DocumentosRepository;
import com.caffeapi.aplication.validators.DocumentoValidator;


@Service
public class DocumentosService {

	@Autowired	
	private DocumentosRepository TipoDocumentoRepositorio;
	
	public List<TipoDocumento> findAll() {
		List<TipoDocumento> TipoDocumentoall = TipoDocumentoRepositorio.findAll();
		return TipoDocumentoall;
	}		
	
	public TipoDocumento findById(Integer Iddocumento) {
		TipoDocumento objTipoDocumento = TipoDocumentoRepositorio.findById(Iddocumento)
				.orElseThrow(() -> new RuntimeException("No existe el tipo de documento."));
		return objTipoDocumento;
	}
	
	@Transactional
	public void delete(Integer iddocumento) {
		TipoDocumento objtipoDocumento = TipoDocumentoRepositorio.findById(iddocumento)
				.orElseThrow(()-> new RuntimeException("No Existe el tipo de documento"));
		
		TipoDocumentoRepositorio.delete(objtipoDocumento);
		
	}	
	
	@Transactional
	public TipoDocumento create(TipoDocumento Tipodocumento) {
		DocumentoValidator.save(Tipodocumento);		
		TipoDocumento nuevoTipoDocumento = TipoDocumentoRepositorio.save(Tipodocumento);
		return nuevoTipoDocumento;
	}
	
	@Transactional
	public TipoDocumento update(TipoDocumento TipoDocumento) {
		TipoDocumento existeTipoDocumento = TipoDocumentoRepositorio.findById(TipoDocumento.getIdDocumento())
				.orElseThrow(()-> new RuntimeException("No Existe el tipo Documento "));
		
		existeTipoDocumento.setTipoDocumentoDesc(TipoDocumento.getTipoDocumentoDesc());
		TipoDocumentoRepositorio.save(existeTipoDocumento);
		return existeTipoDocumento;
	}
}
