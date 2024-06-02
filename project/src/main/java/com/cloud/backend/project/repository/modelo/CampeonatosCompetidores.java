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
@Table(name = "campeonatos_competidores")
public class CampeonatosCompetidores {
	
	@Id
	@Column(name = "camp_comp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campeonatos_competidores_id_seq")
	@SequenceGenerator(name = "campeonatos_competidores_id_seq", sequenceName = "campeonatos_competidores_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "camp_id")
	private Campeonatos campeonatos;
	
	@ManyToOne
	@JoinColumn(name = "comp_id")
	private Competidores competidores;

	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Campeonatos getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(Campeonatos campeonatos) {
		this.campeonatos = campeonatos;
	}

	public Competidores getCompetidores() {
		return competidores;
	}

	public void setCompetidores(Competidores competidores) {
		this.competidores = competidores;
	}
	
	
	

}
