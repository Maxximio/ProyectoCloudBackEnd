package com.cloud.backend.project.repository.modelo;

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
@Table(name = "campeonatos_pruebas")
public class CampeonatosPruebas {
	
	@Id
	@Column(name = "camp_prue_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campeonatos_pruebas_id_seq")
	@SequenceGenerator(name = "campeonatos_pruebas_id_seq", sequenceName = "campeonatos_pruebas_id_seq", allocationSize = 1, initialValue = 41)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "comp_id")
	private Competidores competidores;
	
	@ManyToOne
	@JoinColumn(name = "prue_id")
	private Pruebas pruebas;

	@ManyToOne
	@JoinColumn(name="camp_id")
	private Campeonatos campeonatos;

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
