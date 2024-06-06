package com.cloud.backend.project.repository.modelo;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
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

    @Column(name = "usua_direccion")
    private String direccion;

    @Column(name = "usua_ciudad")
    private String ciudad;

    @Column(name = "usua_email")
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

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "usuarios",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<UsuariosAsociacionesDeportivas> usuariosAsociacionesDeportivas;

    @OneToMany(mappedBy = "usuarios",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<DocumentosUsuarios> documentosUsuarios;

    @OneToMany(mappedBy = "usuarios",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Competidores> competidores;

    //GET Y SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public String getContactoTelefono() {
        return contactoTelefono;
    }

    public void setContactoTelefono(String contactoTelefono) {
        this.contactoTelefono = contactoTelefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(Boolean estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
