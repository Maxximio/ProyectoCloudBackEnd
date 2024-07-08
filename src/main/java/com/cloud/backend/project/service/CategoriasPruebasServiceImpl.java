package com.cloud.backend.project.service;

import com.cloud.backend.project.service.dto.CampeonatosPruebasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.CategoriasPruebasRepository;
import com.cloud.backend.project.repository.modelo.CategoriasPruebas;

@Service
public class CategoriasPruebasServiceImpl implements CategoriasPruebasService{
	
	@Autowired
	private CategoriasPruebasRepository categoriasPruebasRepository;

	@Override
	public CategoriasPruebas buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.categoriasPruebasRepository.buscarId(id);
	}

	@Override
	public CampeonatosPruebasDTO buscarPorIdDTO(Integer id) {
		CampeonatosPruebasDTO campeonatosPruebasDTO = new CampeonatosPruebasDTO();
		return null;
	}

	@Override
	public void insertarCategoriasPruebas(CategoriasPruebas categoriasPruebas) {
		// TODO Auto-generated method stub
		this.categoriasPruebasRepository.insertar(categoriasPruebas);
	}

	@Override
	public void actualizarCategoriasPruebas(CategoriasPruebas categoriasPruebas) {
		// TODO Auto-generated method stub
		this.categoriasPruebasRepository.actualizar(categoriasPruebas);
	}

	@Override
	public void eliminarCategoriasPruebas(Integer id) {
		// TODO Auto-generated method stub
		this.categoriasPruebasRepository.eliminar(id);
	}

}
