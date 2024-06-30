package com.cloud.backend.project.repository.modelo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Usuarios {

    @Id
    @Column(name = "usua_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_usua_id_seq")
    @SequenceGenerator(name = "usuarios_usua_id_seq", sequenceName = "usuarios_usua_id_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "usua_nombres")
    private String nombres;

    @Column(name = "usua_apellidos")
    private String apellidos;

    //@Column(name = "usua_cedula")
   // private String cedula;

    @Column(name = "usua_direccion")
    private String direccion;

    @Column(name = "usua_ciudad")
    private String ciudad;

    @Column(name = "usua_email",nullable = false)
    private String email;

    @Column(name = "usua_telefono")
    private String telefono;

    @Column(name = "usua_cont_nombre")
    private String contactoNombre;

    @Column(name = "usua_cont_telf") //Aqui crearon otra columna, "usua_cont_telfefono", no se con cual se queden
    private String contactoTelefono;

    @Column(name = "usua_password")
    private String password;

    @Column(name = "usua_fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "usua_sexo")
    private Character sexo;

    @Column(name = "usua_estado")
    private Boolean estado;

    @Column(name = "usua_estado_reg")
    private Boolean estadoRegistro;

    @Column(name = "usua_fecha_suscripción")
    private Date fechaSuscripción;

    /*@ManyToMany(fetch = FetchType.EAGER, targetEntity = Roles.class,cascade = CascadeType.PERSIST)
	@JoinTable(name="usua_roles", joinColumns=@JoinColumn(name="usua_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Roles> roles;*/

    @ManyToOne
    @JoinColumn(name ="role_id")
    private Roles roles;

    @OneToMany(mappedBy = "usuarios",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<UsuariosAsociacionesDeportivas> usuariosAsociacionesDeportivas;

    @OneToMany(mappedBy = "usuarios",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<DocumentosUsuarios> documentosUsuarios;

    @OneToMany(mappedBy = "usuarios",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Competidores> competidores;

    //GET Y SET
    
}
