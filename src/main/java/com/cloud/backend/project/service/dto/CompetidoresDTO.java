package com.cloud.backend.project.service.dto;

import java.util.Date;
import java.util.List;

import com.cloud.backend.project.repository.modelo.AsociacionesDeportivas;
import com.cloud.backend.project.repository.modelo.CampeonatosCompetidores;
import com.cloud.backend.project.repository.modelo.CompetidoresPruebas;
import com.cloud.backend.project.repository.modelo.Resultados;
import com.cloud.backend.project.repository.modelo.Usuarios;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetidoresDTO {

	private Integer id;
	private Date fechaInscripcion;
	private String cuentaBancaria;
	private UsuarioDTO usuarios;
	private AsociacionesDeportivas asociacionesDeportivas;
	private List<Resultados> resultados;
	private List<CampeonatosCompetidores> campeonatosCompetidores;
	private List<CompetidoresPruebas> competidoresPruebas;
}
