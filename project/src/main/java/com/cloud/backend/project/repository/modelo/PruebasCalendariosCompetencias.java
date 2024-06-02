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
@Table(name = "pruebas_calendarios_competencias")
public class PruebasCalendariosCompetencias {

	
	@Id
	@Column(name = "prue_caco_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pruebas_calendarios_competencias_id_seq")
	@SequenceGenerator(name = "pruebas_calendarios_competencias_id_seq", sequenceName = "pruebas_calendarios_competencias_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "prue_id")
	private Pruebas pruebas;
	
	@ManyToOne
	@JoinColumn(name = "caco_id")
	private CampeonatosCompetidores campeonatosCompetidores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pruebas getPruebas() {
		return pruebas;
	}

	public void setPruebas(Pruebas pruebas) {
		this.pruebas = pruebas;
	}

	public CampeonatosCompetidores getCampeonatosCompetidores() {
		return campeonatosCompetidores;
	}

	public void setCampeonatosCompetidores(CampeonatosCompetidores campeonatosCompetidores) {
		this.campeonatosCompetidores = campeonatosCompetidores;
	}
	
	
		
	
	
}
