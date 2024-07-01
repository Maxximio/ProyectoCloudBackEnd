package com.cloud.backend.project.repository.modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "campeonatos_pruebas_competidores")
public class CampeonatosPruebasCompetidores {
    
    @Id
	@Column(name = "camp_prco_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campeonatos_pruebas_competidores_id_seq")
	@SequenceGenerator(name = "campeonatos_pruebas_competidores_id_seq", sequenceName = "campeonatos_pruebas_competidores_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

    @ManyToOne
	@JoinColumn(name = "camp_prue_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
	private CampeonatosPruebas campeonatosPruebas;

    @ManyToOne
	@JoinColumn(name = "comp_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Competidores competidores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CampeonatosPruebas getCampeonatosPruebas() {
        return campeonatosPruebas;
    }

    public void setCampeonatosPruebas(CampeonatosPruebas campeonatosPruebas) {
        this.campeonatosPruebas = campeonatosPruebas;
    }

    public Competidores getCompetidores() {
        return competidores;
    }

    public void setCompetidores(Competidores competidores) {
        this.competidores = competidores;
    }
}
