package com.cloud.backend.project.repository.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "documentos_usuarios")
public class DocumentosUsuarios {

    @Id
    @Column(name = "dous_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dous_id_seq")
    @SequenceGenerator(name = "dous_id_seq", sequenceName = "dous_id_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "dous_nombre")
    private String nombre;

    @Column(name = "dous_link")
    private String link;

    @Column(name = "dous_extension")
    private String extension;

    @ManyToOne
    @JoinColumn(name = "usua_id")
    private Usuarios usuarios;

    //get y set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
