package com.cloud.backend.project.repository.modelo;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "asociaciones_deportivas")
public class AsociacionesDeportivas {
	
	
	@Id
	@Column(name = "asde_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asociaciones_deportivas_id_seq")
	@SequenceGenerator(name = "asociaciones_deportivas_id_seq", sequenceName = "asociaciones_deportivas_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@Column(name = "asde_nombre")
	private String nombre;
	

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
