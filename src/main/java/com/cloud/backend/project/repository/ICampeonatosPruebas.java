package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebas;
import java.util.*;

public interface ICampeonatosPruebas {
	
	public Boolean insertar(CampeonatosPruebas campeonatosPruebas);
	public Boolean actualizar(CampeonatosPruebas campeonatosPruebas);
	public Boolean eliminar(Integer id);
	public CampeonatosPruebas buscarPorId(Integer id);
	public List<CampeonatosPruebas> buscarPorIdCampeonatos(Integer idCampeonato);
	public List<CampeonatosPruebas> obtenerTodos();

}
