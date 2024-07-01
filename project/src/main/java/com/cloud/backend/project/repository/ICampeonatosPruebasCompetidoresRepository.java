package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebasCompetidores;

public interface ICampeonatosPruebasCompetidoresRepository {
    
    public Boolean insertar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores);
	public Boolean actualizar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores);
	public Boolean eliminar(Integer id);
	public CampeonatosPruebasCompetidores buscarPorId(Integer id);

}
