package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.CompetidoresPruebas;
import com.cloud.backend.project.service.dto.CompetidoresDTO;
import com.cloud.backend.project.service.dto.CompetidoresPruebasDTO;

import java.util.HashMap;
import java.util.List;

public interface ICompetidoresPruebasService {
	
	public Boolean insertar(CompetidoresPruebas competidoresPruebas);

	public CompetidoresPruebas buscarPorId(Integer id);

	public Boolean actualizar(CompetidoresPruebas competidoresPruebas);

	public Boolean eliminar(Integer id);
	public List<CompetidoresPruebas> obtenerTodos();
	HashMap<String,List<CompetidoresDTO>> obtenerTodosDTO();
}
