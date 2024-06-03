package com.cloud.backend.project.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pruebas")
public class Pruebas {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pruebas_prue_id_seq")
	@SequenceGenerator(name = "pruebas_prue_id_seq", sequenceName = "pruebas_prue_id_seq", allocationSize = 1)
	@Column(name = "prue_id")
	private Integer id;
	
	@Column(name = "prue_nombre")
	private String nombre;

	@Column(name = "prue_intentos")
	private Integer intentos;

	@Column(name = "prue_tipo")
	private String tipo;
	
	@OneToMany(mappedBy = "pruebas", cascade = CascadeType.ALL)
	private List<Resultados> resultados;
	
	@OneToMany(mappedBy = "pruebas", cascade = CascadeType.ALL)
	private List<CompetidoresPruebas> competidoresPruebas;
	
	@OneToMany(mappedBy = "pruebas", cascade = CascadeType.ALL)
	private List<PruebasCalendariosCompetencias> pruebasCalendariosCompetencias;
	
	@OneToMany(mappedBy = "pruebas", cascade = CascadeType.ALL)
	private List<CampeonatosPruebas> campeonatosPruebas;
	
	@OneToMany(mappedBy = "pruebas", cascade = CascadeType.ALL)
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

	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Resultados> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultados> resultados) {
		this.resultados = resultados;
	}

	public List<CompetidoresPruebas> getCompetidoresPruebas() {
		return competidoresPruebas;
	}

	public void setCompetidoresPruebas(List<CompetidoresPruebas> competidoresPruebas) {
		this.competidoresPruebas = competidoresPruebas;
	}

	public List<PruebasCalendariosCompetencias> getPruebasCalendariosCompetencias() {
		return pruebasCalendariosCompetencias;
	}

	public void setPruebasCalendariosCompetencias(List<PruebasCalendariosCompetencias> pruebasCalendariosCompetencias) {
		this.pruebasCalendariosCompetencias = pruebasCalendariosCompetencias;
	}

	public List<CampeonatosPruebas> getCampeonatosPruebas() {
		return campeonatosPruebas;
	}

	public void setCampeonatosPruebas(List<CampeonatosPruebas> campeonatosPruebas) {
		this.campeonatosPruebas = campeonatosPruebas;
	}

	public List<CategoriasPruebas> getCategoriasPruebas() {
		return categoriasPruebas;
	}

	public void setCategoriasPruebas(List<CategoriasPruebas> categoriasPruebas) {
		this.categoriasPruebas = categoriasPruebas;
	}
	
}


