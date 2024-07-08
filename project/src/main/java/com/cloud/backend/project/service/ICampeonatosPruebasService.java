package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebas;
import com.cloud.backend.project.service.dto.CampeonatosPruebasDTO;

import java.util.List;

public interface ICampeonatosPruebasService {

	public Boolean insertar(CampeonatosPruebas campeonatosPruebas);
	public CampeonatosPruebas buscarPorId(Integer id);
	public CampeonatosPruebasDTO buscarPorIdDto(Integer id);
	public List<CampeonatosPruebasDTO> filtrarCampeonato(Integer idCampeonato);

	public Boolean actualizar(CampeonatosPruebas campeonatosPruebas);
	public Boolean eliminar(Integer id);
	public List<CampeonatosPruebasDTO> obtenerTodos();
}
