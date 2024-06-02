package com.cloud.backend.project.repository.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias_pruebas")
public class CategoriasPruebas {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cate_prue_id_seq")
	@SequenceGenerator(name = "cate_prue_id_seq", sequenceName = "cate_prue_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cate_id")
	private Categorias categorias;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cate_id")
	private Pruebas pruebas;
	
	//GETTERS Y SETTERS
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Categorias getCategorias() {
		return categorias;
	}
	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}
	public Pruebas getPruebas() {
		return pruebas;
	}
	public void setPruebas(Pruebas pruebas) {
		this.pruebas = pruebas;
	}
	
	
	
}
