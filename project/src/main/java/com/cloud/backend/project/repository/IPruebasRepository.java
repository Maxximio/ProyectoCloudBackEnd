package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Pruebas;

public interface IPruebasRepository {
	
	public Boolean insertar(Pruebas pruebas);

	public Pruebas buscarPorId(Integer id);

	public Boolean actualizar(Pruebas pruebas);

	public Boolean eliminar(Integer id);

}
