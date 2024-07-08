package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebasCompetidores;
import com.cloud.backend.project.service.dto.CampeonatoPruebasCompetidoresDTO;

import java.util.List;

public interface ICampeonatosPruebasCompetidoresService {
    
    public Boolean insertar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores);
	public Boolean actualizar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores);
	public Boolean eliminar(Integer id);
	public CampeonatosPruebasCompetidores buscarPorId(Integer id);
	public List<CampeonatoPruebasCompetidoresDTO> obtenerTodos();
}
