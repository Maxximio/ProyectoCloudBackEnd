package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.CategoriasPruebas;
import com.cloud.backend.project.service.dto.CampeonatosPruebasDTO;

public interface CategoriasPruebasService {

	public CategoriasPruebas buscarPorId(Integer id);
	public CampeonatosPruebasDTO buscarPorIdDTO(Integer id);
	public void insertarCategoriasPruebas(CategoriasPruebas categoriasPruebas);
	public void actualizarCategoriasPruebas(CategoriasPruebas categoriasPruebas);
	public void eliminarCategoriasPruebas(Integer id);
}
