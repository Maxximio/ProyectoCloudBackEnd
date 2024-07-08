package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.CompetidoresPruebas;

import java.util.List;

public interface ICompetidoresPruebasRepository {
	
	public Boolean insertar(CompetidoresPruebas competidoresPruebas);

	public CompetidoresPruebas buscarPorId(Integer id);

	public Boolean actualizar(CompetidoresPruebas competidoresPruebas);

	public Boolean eliminar(Integer id);
	public List<CompetidoresPruebas> obtenerTodos();

}
