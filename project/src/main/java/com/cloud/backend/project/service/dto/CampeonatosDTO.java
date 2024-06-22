package com.cloud.backend.project.service.dto;

import java.time.LocalDate;
import java.util.List;

public class CampeonatosDTO {
	
	private Integer id;
    private String nombre;
    private String organizador;
    private String sede;
    private LocalDate fechaInicio;
    private LocalDate inscripcionInicio;
    private LocalDate inscripcionFin;
    private List<PruebasDTO> pruebas;
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
	public String getOrganizador() {
		return organizador;
	}
	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getInscripcionInicio() {
		return inscripcionInicio;
	}
	public void setInscripcionInicio(LocalDate inscripcionInicio) {
		this.inscripcionInicio = inscripcionInicio;
	}
	public LocalDate getInscripcionFin() {
		return inscripcionFin;
	}
	public void setInscripcionFin(LocalDate inscripcionFin) {
		this.inscripcionFin = inscripcionFin;
	}
	public List<PruebasDTO> getPruebas() {
		return pruebas;
	}
	public void setPruebas(List<PruebasDTO> pruebas) {
		this.pruebas = pruebas;
	}
    
    

}
