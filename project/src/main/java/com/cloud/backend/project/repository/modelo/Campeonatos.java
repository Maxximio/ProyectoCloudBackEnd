package com.cloud.backend.project.repository.modelo;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="campeonatos")
public class Campeonatos {


    @Id
	@Column(name = "camp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "camp_id_seq")
	@SequenceGenerator(name = "camp_id_seq", sequenceName = "camp_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

    @Column(name = "camp_nombre")
    private String nombre;
    @Column(name = "camp_organizador")
	private String  organizador;
	@Column(name = "camp_sede")
	private String sede;
	@Column(name = "camp_fecha_inicio")
	private LocalDate fechaInicio;
	@Column(name = "camp_inscripcion_inicio")
	private LocalDate inscripcionInicio;
	@Column(name = "camp_inscripcion_fin")
	private LocalDate inscripcionFin;

    @OneToMany(mappedBy = "campeonatos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<PreciosInscripciones> preciosInscripciones;

    @OneToMany(mappedBy = "campeonatos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CampeonatosPruebas> campeonatosPruebas;

    @OneToMany(mappedBy = "campeonatos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CalendariosCompetencias> calendariosCompetencias;

    @OneToMany(mappedBy = "campeonatos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CampeonatosCompetidores> campeonatosCompetidores;

    @OneToMany(mappedBy = "campeonatos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<AsociacionesDeportivasCampeonatos> asociacionesDeportivasCampeonatos;

    //Getters and Setters
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

    public List<PreciosInscripciones> getPreciosInscripciones() {
        return preciosInscripciones;
    }

    public void setPreciosInscripciones(List<PreciosInscripciones> preciosInscripciones) {
        this.preciosInscripciones = preciosInscripciones;
    }

    public List<CampeonatosPruebas> getCampeonatosPruebas() {
        return campeonatosPruebas;
    }

    public void setCampeonatosPruebas(List<CampeonatosPruebas> campeonatosPruebas) {
        this.campeonatosPruebas = campeonatosPruebas;
    }

    public List<CalendariosCompetencias> getCalendariosCompetencias() {
        return calendariosCompetencias;
    }

    public void setCalendariosCompetencias(List<CalendariosCompetencias> calendariosCompetencias) {
        this.calendariosCompetencias = calendariosCompetencias;
    }

    public List<CampeonatosCompetidores> getCampeonatosCompetidores() {
        return campeonatosCompetidores;
    }

    public void setCampeonatosCompetidores(List<CampeonatosCompetidores> campeonatosCompetidores) {
        this.campeonatosCompetidores = campeonatosCompetidores;
    }

    public List<AsociacionesDeportivasCampeonatos> getAsociacionesDeportivasCampeonatos() {
        return asociacionesDeportivasCampeonatos;
    }

    public void setAsociacionesDeportivasCampeonatos(
            List<AsociacionesDeportivasCampeonatos> asociacionesDeportivasCampeonatos) {
        this.asociacionesDeportivasCampeonatos = asociacionesDeportivasCampeonatos;
    } 


    


}
