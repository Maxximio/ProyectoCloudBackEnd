package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Categorias;

public interface ICategoriasRepository {
	
	public Boolean insertar(Categorias categorias);
	public Categorias buscarPorId(Integer id);
	public Boolean actualizar(Categorias categorias);
	public Boolean eliminar(Integer id);

}
