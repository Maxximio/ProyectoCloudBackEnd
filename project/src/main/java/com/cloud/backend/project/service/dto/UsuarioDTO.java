package com.cloud.backend.project.service.dto;

import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {

    private String nombres;
    private String apellidos;
    private String ciudad;
    private String email;
    private String telefono;
    private Date fechaNacimiento;
    private Character sexo;
    private Boolean estado;
    private Date fechaSuscripción;
    private DocumentosUsuarios documento;


}
