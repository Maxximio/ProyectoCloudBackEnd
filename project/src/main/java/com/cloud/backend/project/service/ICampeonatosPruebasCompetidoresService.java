package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebasCompetidores;

public interface ICampeonatosPruebasCompetidoresService {
    
    public Boolean insertar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores);
	public Boolean actualizar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores);
	public Boolean eliminar(Integer id);
	public CampeonatosPruebasCompetidores buscarPorId(Integer id);

}
