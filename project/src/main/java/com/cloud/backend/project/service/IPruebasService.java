package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.Pruebas;

public interface IPruebasService {
	
	public Boolean insertar(Pruebas pruebas);

	public Pruebas buscarPorId(Integer id);

	public Boolean actualizar(Pruebas pruebas);

	public Boolean eliminar(Integer id);

}
