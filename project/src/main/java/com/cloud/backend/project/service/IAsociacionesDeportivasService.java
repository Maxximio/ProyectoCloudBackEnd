package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.AsociacionesDeportivas;

public interface IAsociacionesDeportivasService {
	
	public Boolean insertar(AsociacionesDeportivas asociacionesDeportivas);
	public Boolean actualizar(AsociacionesDeportivas asociaDeportivas);
	public Boolean eliminar(Integer id);
	public AsociacionesDeportivas buscarPorId(Integer id);

}
