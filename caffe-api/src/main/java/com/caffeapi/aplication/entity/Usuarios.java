package com.caffeapi.aplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Usuarios")
public class Usuarios {

	@Id
	@Column(name="idusuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name="Numerodocumento" , nullable = false , length = 100)
	private String NumeroDocumento;
	
	@Column(name="Nombreusuario" , nullable = false , length = 100)
	private String NombreUsuario;
	
	@Column(name="Apellidousuario" , nullable = false , length = 100)
	private String ApellidoUsuario;
	
	@Column(name="Generousuario" ,nullable = false , length = 10)
	private String GeneroUsuario;
	
	@Column(name="Fechanacimiento" ,nullable = false , length = 10)
	private String FechaNacimiento;
	
	@Column(name="Numerotel", nullable = false , length = 15)
	private String NumeroTel;
	
	@Column(name="Correousuario", nullable = false , length = 50)
	private String CorreoUsuario;
	
	@Column(name="Contrasenausuario", nullable = false , length = 20)
	private String ContrasenaUsuario;
		
	@ManyToOne
    @JoinColumn(name = "usu_doc", nullable = true, updatable = false)
    private TipoDocumento tipodocumento;
	
	@ManyToOne
    @JoinColumn(name = "usu_per", nullable = true, updatable = false)
	private Perfil perfil;

	
	public Usuarios() {}
}
