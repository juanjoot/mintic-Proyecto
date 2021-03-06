package com.caffeapi.aplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caffeapi.aplication.entity.TipoDocumento;
import com.caffeapi.aplication.services.DocumentosService;

@RestController
public class DocumentoController {

	@Autowired
	private DocumentosService TipDocServicio;
	
	
	@GetMapping(value = "/tipodocumento/{iddocumento}")
	public ResponseEntity<TipoDocumento> findById(@PathVariable("iddocumento") Integer iddocumento) {
		TipoDocumento objTipoDocumento = TipDocServicio.findById(iddocumento);			
		return new ResponseEntity<TipoDocumento>(objTipoDocumento, HttpStatus.OK);
	}

	@DeleteMapping(value = "/tipodocumento/{iddocumento}")
	public ResponseEntity<Void> delete(@PathVariable("iddocumento") Integer iddocumento) {
		TipDocServicio.delete(iddocumento);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping(value = "/tipodocumento")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<TipoDocumento>> findAll() {
		List<TipoDocumento> TipoDocumentosall = TipDocServicio.findAll();
		return new ResponseEntity<List<TipoDocumento>>(TipoDocumentosall, HttpStatus.OK);
	}

	@PostMapping(value = "/tipodocumento")
	public ResponseEntity<TipoDocumento> create(@RequestBody TipoDocumento TipoDocumento) {
		TipoDocumento nuevoTipoDocumento = TipDocServicio.create(TipoDocumento);
		return new ResponseEntity<TipoDocumento>(nuevoTipoDocumento, HttpStatus.CREATED);
	}

	@PutMapping(value = "/tipodocumento")
	public ResponseEntity<TipoDocumento> update(@RequestBody TipoDocumento TipoDocumento) {
		TipoDocumento existeTipoDocumento = TipDocServicio.update(TipoDocumento);		
		return new ResponseEntity<TipoDocumento>(existeTipoDocumento, HttpStatus.OK);
	}
	
}
