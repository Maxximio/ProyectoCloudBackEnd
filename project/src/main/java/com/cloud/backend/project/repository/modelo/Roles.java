package com.cloud.backend.project.repository.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    @SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "role_descripcion")
    private String descripcion;

    @Column(name = "role_codigo")
    private String codigo;

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Usuarios> usuarios;

    //get y set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
