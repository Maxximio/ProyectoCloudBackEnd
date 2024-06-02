package com.cloud.backend.project.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categorias {
	
	@Id
	@Column(name = "cate_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cate_id_seq")
	@SequenceGenerator(name = "cate_id_seq", sequenceName = "cate_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@Column(name = "cate_nombre")
	private String nombre;
	
	@Column(name = "cate_edad_minima")
	private Integer edadMinima;
	
	@Column(name = "cate_edad_maxima")
	private Integer edadMaxima;
	
	@Column(name = "cate_genero")
	private char genero;
	
	@OneToMany(mappedBy = "categorias")
	private List<CategoriasPruebas> categoriasPruebas;

	
	//SET y GET
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

	public Integer getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(Integer edadMinima) {
		this.edadMinima = edadMinima;
	}

	public Integer getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(Integer edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public List<CategoriasPruebas> getCategoriasPruebas() {
		return categoriasPruebas;
	}

	public void setCategoriasPruebas(List<CategoriasPruebas> categoriasPruebas) {
		this.categoriasPruebas = categoriasPruebas;
	}
	
	
	


}
