package com.cloud.backend.project.service.dto;

import java.util.List;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebas;
import com.cloud.backend.project.repository.modelo.CategoriasPruebas;
import com.cloud.backend.project.repository.modelo.CompetidoresPruebas;
import com.cloud.backend.project.repository.modelo.PruebasCalendariosCompetencias;
import com.cloud.backend.project.repository.modelo.Resultados;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PruebasDTO {
	
	private Integer id;
    private String nombre;
    private Integer intentos;
    private String tipo;
    private String descripcion;
    private String categoria;
    
}
