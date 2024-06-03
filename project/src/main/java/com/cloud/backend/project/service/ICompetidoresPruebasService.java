package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.CompetidoresPruebas;

public interface ICompetidoresPruebasService {
	
	public Boolean insertar(CompetidoresPruebas competidoresPruebas);

	public CompetidoresPruebas buscarPorId(Integer id);

	public Boolean actualizar(CompetidoresPruebas competidoresPruebas);

	public Boolean eliminar(Integer id);

}
