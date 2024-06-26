package com.cloud.backend.project.repository.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    @SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "role_descripcion",nullable = false)
    private String descripcion;

    @Column(name = "role_codigo",nullable = false)
    //@Enumerated(EnumType.STRING)
    //private ERol codigo;
    private String codigo;

    /*public Roles(String descripcion, ERol codigo) {
        this.descripcion=descripcion;
    	this.codigo = codigo;
    }*/

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Usuarios> usuarios;

    //get y set

}
