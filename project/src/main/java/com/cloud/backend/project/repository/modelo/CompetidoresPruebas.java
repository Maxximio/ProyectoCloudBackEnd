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
@Table(name = "competidores_pruebas")
public class CompetidoresPruebas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competidores_pruebas_comp_prue_id_seq")
	@SequenceGenerator(name = "competidores_pruebas_comp_prue_id_seq", sequenceName = "competidores_pruebas_comp_prue_id_seq", allocationSize = 1)
	@Column(name = "comp_prue_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "prue_id")
	private Pruebas pruebas;
	
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

	public Pruebas getPruebas() {
		return pruebas;
	}

	public void setPruebas(Pruebas pruebas) {
		this.pruebas = pruebas;
	}

	public Competidores getCompetidores() {
		return competidores;
	}

	public void setCompetidores(Competidores competidores) {
		this.competidores = competidores;
	}
	
	

}
