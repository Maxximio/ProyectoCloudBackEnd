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
@Table(name = "precios_inscripciones")
public class PreciosInscripciones {

	@Id
	@Column(name = "prin_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "precios_inscripciones_id_seq")
	@SequenceGenerator(name = "precios_inscripciones_id_seq", sequenceName = "precios_inscripciones_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@Column(name = "prin_costo_socio")
	private Integer costoSocio;
	@Column(name = "prin_costo_no_socio")
	private Integer costoNoSocio;
	@Column(name = "prin_costo_prueba_adicional")
	private Integer costoPruebaAdicional;
	@Column(name = "prin_cuenta_bancaria")
	private String cuentaBancaria;
	
	@ManyToOne
	@JoinColumn(name = "camp_id")
	private Campeonatos campeonatos;
	
	//toString
	/*@Override
	public String toString() {
		return "PreciosInscripciones [id=" + id + ", costoSocio=" + costoSocio + ", costoNoSocio=" + costoNoSocio
				+ ", costoPruebaAdicional=" + costoPruebaAdicional + ", cuentaBancaria=" + cuentaBancaria
				+ ", campeonato=" + campeonato + "]";
	}*/

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCostoSocio() {
		return costoSocio;
	}

	public void setCostoSocio(Integer costoSocio) {
		this.costoSocio = costoSocio;
	}

	public Integer getCostoNoSocio() {
		return costoNoSocio;
	}

	public void setCostoNoSocio(Integer costoNoSocio) {
		this.costoNoSocio = costoNoSocio;
	}

	public Integer getCostoPruebaAdicional() {
		return costoPruebaAdicional;
	}

	public void setCostoPruebaAdicional(Integer costoPruebaAdicional) {
		this.costoPruebaAdicional = costoPruebaAdicional;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public Campeonatos getCampeonato() {
		return campeonatos;
	}

	public void setCampeonato(Campeonatos campeonatos) {
		this.campeonatos = campeonatos;
	}
	
}
