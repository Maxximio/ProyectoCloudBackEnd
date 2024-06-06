package com.cloud.backend.project.repository.modelo;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "competidores")
public class Competidores {

    @Id
	@Column(name = "comp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competidor_id_seq")
	@SequenceGenerator(name = "competidor_id_seq", sequenceName = "competidor_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@Column(name = "comp_fecha_inscripcion")
	private Date fechaInscripcion;

	@Column(name = "comp_estado_participacion")
	private String cuentaBancaria;
	
	@ManyToOne
	@JoinColumn(name = "usua_id")
	private Usuarios usuarios;

    @ManyToOne
	@JoinColumn(name = "asde_id")
	private AsociacionesDeportivas asociacionesDeportivas;

    @OneToMany(mappedBy = "competidores",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Resultados> resultados;

    @OneToMany(mappedBy = "competidores",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CampeonatosCompetidores> campeonatosCompetidores;

    @OneToMany(mappedBy = "competidores",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CompetidoresPruebas> competidoresPruebas;

    /*//to string
    @Override
    public String toString() {
        return "Competidores [id=" + id + ", fechaInscripcion=" + fechaInscripcion + ", cuentaBancaria="
                + cuentaBancaria + ", usuarios=" + usuarios + ", asociacionesDeportivas=" + asociacionesDeportivas
                + "]";
    }*/

    //getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public AsociacionesDeportivas getAsociacionesDeportivas() {
        return asociacionesDeportivas;
    }

    public void setAsociacionesDeportivas(AsociacionesDeportivas asociacionesDeportivas) {
        this.asociacionesDeportivas = asociacionesDeportivas;
    }

}
