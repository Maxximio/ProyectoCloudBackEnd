package com.cloud.backend.project.repository.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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

	@Column(name = "dous_tipo")
    private String tipo;
    
  //get y set

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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
}
