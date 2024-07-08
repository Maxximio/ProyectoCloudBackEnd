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
@Table(name = "asociaciones_deportivas_campeonatos")
public class AsociacionesDeportivasCampeonatos {
    
    @Id
	@Column(name = "asde_camp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asociaciones_deportivas_campeonatos_id_seq")
	@SequenceGenerator(name = "asociaciones_deportivas_campeonatos_id_seq", sequenceName = "asociaciones_deportivas_campeonatos_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

    @ManyToOne
	@JoinColumn(name = "asde_id")
	private AsociacionesDeportivas asociacionesDeportivas;

    @ManyToOne
	@JoinColumn(name = "camp_id")
	private Campeonatos campeonatos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AsociacionesDeportivas getAsociacionesDeportivas() {
        return asociacionesDeportivas;
    }

    public void setAsociacionesDeportivas(AsociacionesDeportivas asociacionesDeportivas) {
        this.asociacionesDeportivas = asociacionesDeportivas;
    }

    public Campeonatos getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(Campeonatos campeonatos) {
        this.campeonatos = campeonatos;
    }

}
