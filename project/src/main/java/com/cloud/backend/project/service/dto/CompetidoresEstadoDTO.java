package com.cloud.backend.project.service.dto;

import com.cloud.backend.project.repository.modelo.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetidoresEstadoDTO {

    private Integer id;

    private Date fechaInscripcion;
    private String estadoParticipacion;
    private Integer idUsuario;
    private String nombres;
    private String apellidos;
    private String ciudad;
    private String email;
    private String telefono;
    private Date fechaNacimiento;
    private Character sexo;
    private DocumentosUsuarios documentos;
}
