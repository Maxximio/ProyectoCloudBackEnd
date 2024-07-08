package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.CategoriasPruebas;

public interface CategoriasPruebasRepository {

	public CategoriasPruebas buscarId(Integer id);
	public void insertar(CategoriasPruebas categoriasPruebas);
	public void actualizar(CategoriasPruebas categoriasPruebas);
	public void eliminar(Integer id);
}
