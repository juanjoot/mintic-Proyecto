package com.caffeapi.aplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Tipodocumento")

public class TipoDocumento {

	
	@Id
	@Column(name="iddocumento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idDocumento;
	
	@Column(name="Tipodocumentodesc" , nullable = false , length = 100)
	private String TipoDocumentoDesc;		
	
	public TipoDocumento() {}
}
