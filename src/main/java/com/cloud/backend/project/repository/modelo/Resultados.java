package com.cloud.backend.project.repository.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "resultados")
public class Resultados {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resu_id_seq")
	@SequenceGenerator(name = "resu_id_seq", sequenceName = "resu_id_seq", allocationSize = 1, initialValue = 1)
	@Column(name = "resu_id")
	private Integer id;
	@Column(name = "resu_intento")
	private Integer intento;
	@Column(name = "resu_marca")
	private String marca;
	@Column(name = "resu_medida")
	private String medida;
	@Column(name = "resu_unidad")
	private String unidad;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "comp_id")
	private Competidores competidores;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prue_id")
	private Pruebas pruebas;

	// GETTERS Y SETTERS

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIntento() {
		return intento;
	}

	public void setIntento(Integer intento) {
		this.intento = intento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Competidores getCompetidores() {
		return competidores;
	}

	public void setCompetidores(Competidores competidores) {
		this.competidores = competidores;
	}

	public Pruebas getPruebas() {
		return pruebas;
	}

	public void setPruebas(Pruebas pruebas) {
		this.pruebas = pruebas;
	}

}
