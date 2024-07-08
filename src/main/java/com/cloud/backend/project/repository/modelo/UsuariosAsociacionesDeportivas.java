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
@Table(name = "usuarios_asociaciones_deportivas")
public class UsuariosAsociacionesDeportivas {

    @Id
	@Column(name = "usua_asde_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usua_asde_id_seq")
	@SequenceGenerator(name = "usua_asde_id_seq", sequenceName = "usua_asde_id_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usua_id")
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name="asde_id")
    private AsociacionesDeportivas asociacionesDeportivas;


    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
