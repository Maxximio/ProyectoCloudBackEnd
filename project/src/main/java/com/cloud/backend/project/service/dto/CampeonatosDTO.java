package com.cloud.backend.project.service.dto;


import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampeonatosDTO {

	
	private Integer id;
    private String nombre;
    private String organizador;
    private String sede;
    private LocalDate fechaInicio;
    private LocalDate inscripcionInicio;
    private LocalDate inscripcionFin;
    private List<PruebasDTO> pruebas;  

}
