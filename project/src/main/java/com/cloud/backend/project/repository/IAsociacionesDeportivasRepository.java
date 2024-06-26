package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.AsociacionesDeportivas;

public interface IAsociacionesDeportivasRepository {
	
	public Boolean insertar( AsociacionesDeportivas asociacionesDeportivas);
	public Boolean actualizar(AsociacionesDeportivas asocicacionesDeportivas);
	public Boolean eliminar(Integer id);
	public AsociacionesDeportivas buscarPorId(Integer id);

}
