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
@Table(name="Perfil")

public class Perfil {


	@Id
	@Column(name="perfilId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer perfilId;	
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;	
	

	public Perfil() {
		
	}
	
}
