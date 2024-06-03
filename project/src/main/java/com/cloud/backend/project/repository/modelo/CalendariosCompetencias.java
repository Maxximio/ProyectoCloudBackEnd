package com.cloud.backend.project.repository.modelo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "calendarios_competencias")
public class CalendariosCompetencias {

    @Id
    @Column(name = "caco_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendarios_competencias_id_seq")
    @SequenceGenerator(name = "calendarios_competencias_id_seq", sequenceName = "calendarios_competencias_id_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "caco_fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "camp_id")
    private Campeonatos campeonatos;

    //GET Y SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Campeonatos getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(Campeonatos campeonatos) {
        this.campeonatos = campeonatos;
    }
}
