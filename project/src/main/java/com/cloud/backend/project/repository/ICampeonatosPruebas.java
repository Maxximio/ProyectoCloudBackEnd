package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebas;

public interface ICampeonatosPruebas {
	
	public Boolean insertar(CampeonatosPruebas campeonatosPruebas);
	public Boolean actualizar(CampeonatosPruebas campeonatosPruebas);
	public Boolean eliminar(Integer id);
	public CampeonatosPruebas buscarPorId(Integer id);

}
