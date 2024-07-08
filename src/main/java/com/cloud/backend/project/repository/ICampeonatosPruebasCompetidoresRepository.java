package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebas;
import com.cloud.backend.project.repository.modelo.CampeonatosPruebasCompetidores;
import com.cloud.backend.project.service.dto.CampeonatoPruebasCompetidoresDTO;

import java.util.List;

public interface ICampeonatosPruebasCompetidoresRepository {
    
    public Boolean insertar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores);
	public Boolean actualizar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores);
	public Boolean eliminar(Integer id);
	public CampeonatosPruebasCompetidores buscarPorId(Integer id);
	public List<CampeonatosPruebasCompetidores> buscarTodos();
}
