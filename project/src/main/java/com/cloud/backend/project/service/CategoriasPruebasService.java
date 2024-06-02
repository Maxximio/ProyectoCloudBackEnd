package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.CategoriasPruebas;

public interface CategoriasPruebasService {

	public CategoriasPruebas buscarPorId(Integer id);
	public void insertarCategoriasPruebas(CategoriasPruebas categoriasPruebas);
	public void actualizarCategoriasPruebas(CategoriasPruebas categoriasPruebas);
	public void eliminarCategoriasPruebas(Integer id);
}
