package com.cloud.backend.project.repository.modelo;
import java.io.Serializable;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse implements Serializable{

    private static final long serialVersionUID =1L;

    private Integer id;
    private String nombres;
    private String apellidos;
    //private String cedula;
    private String direccion;
    private String ciudad;
    private String email;
    private String telefono;
    private String contactoNombre;
    private String contactoTelefono;
    private String password;
    private Date fechaNacimiento;
    private Character sexo;
    private Boolean estado;
    private Boolean estadoRegistro;
    
    //private List<Roles> roles;
    private Roles roles;
}
