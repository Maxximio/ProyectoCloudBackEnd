package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Pruebas;

import java.util.List;

public interface IPruebasRepository {
	
	public Boolean insertar(Pruebas pruebas);

	public Pruebas buscarPorId(Integer id);

	public Boolean actualizar(Pruebas pruebas);

	public Boolean eliminar(Integer id);
	public List<Pruebas> buscarTodas();
}
