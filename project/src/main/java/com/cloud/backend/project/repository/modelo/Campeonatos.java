package com.cloud.backend.project.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="campeonatos")
public class Campeonatos {


    @Id
	@Column(name = "camp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "camp_id_seq")
	@SequenceGenerator(name = "camp_id_seq", sequenceName = "camp_id_seq", allocationSize = 1, initialValue = 50)
	private Integer id;

    @Column(name = "camp_nombre")
    private String nombre;
    @Column(name = "camp_organizador")
	private String  organizador;
	@Column(name = "camp_sede")
	private String sede;
	@Column(name = "camp_fecha_inicio")
	private LocalDate fechaInicio;
    //
    @Column(name = "camp_fecha_fin")
    private LocalDate fechaFin;
    //
	@Column(name = "camp_inscripcion_inicio")
	private LocalDate inscripcionInicio;
	@Column(name = "camp_inscripcion_fin")
	private LocalDate inscripcionFin;

    @OneToMany(mappedBy = "campeonatos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PreciosInscripciones> preciosInscripciones;

    @OneToMany(mappedBy = "campeonatos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CampeonatosPruebas> campeonatosPruebas;

    @OneToMany(mappedBy = "campeonatos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CalendariosCompetencias> calendariosCompetencias;

    @OneToMany(mappedBy = "campeonatos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CampeonatosCompetidores> campeonatosCompetidores;

    @OneToMany(mappedBy = "campeonatos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AsociacionesDeportivasCampeonatos> asociacionesDeportivasCampeonatos;

    //Getters and Setters
    
}
