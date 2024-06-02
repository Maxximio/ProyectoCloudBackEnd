package com.cloud.backend.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.ICategoriasRepository;
import com.cloud.backend.project.repository.modelo.Categorias;

@Service
public class CategoriasServiceImpl implements ICategoriasService{

	@Autowired
	private ICategoriasRepository categoriasRepository;
	
	@Override
	public Boolean insertar(Categorias categorias) {
		return this.categoriasRepository.insertar(categorias);
	}

	@Override
	public Categorias buscarPorId(Integer id) {
		return this.categoriasRepository.buscarPorId(id);
	}

	@Override
	public Boolean actualizar(Categorias categorias) {
		return this.categoriasRepository.actualizar(categorias);
	}

	@Override
	public Boolean eliminar(Integer id) {
		return this.categoriasRepository.eliminar(id);
	}

}
