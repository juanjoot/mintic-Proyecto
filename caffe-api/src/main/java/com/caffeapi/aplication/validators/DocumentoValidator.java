package com.caffeapi.aplication.validators;

import com.caffeapi.aplication.entity.TipoDocumento;

public class DocumentoValidator {

	
	public static void save (TipoDocumento TipoDocumento) {
		
		
		if (TipoDocumento.getTipoDocumentoDesc() == null || TipoDocumento.getTipoDocumentoDesc().trim().isEmpty() ) {
			
			throw new RuntimeException("el nombre del tipo de documento es requerido");
		}
		
		if (TipoDocumento.getTipoDocumentoDesc().length() > 20 ) {
			
			throw new RuntimeException("el nombre del tipo de documento no puede exceder los 20 caracteres");
		}
	
	}

}
