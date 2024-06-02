package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.PreciosInscripciones;

public interface IPreciosInscripcionesService {
	
	public Boolean insertar(PreciosInscripciones preciosInscripciones);
	public Boolean actualizar(PreciosInscripciones preciosInscripciones);
	public Boolean eliminar(Integer id);
	public PreciosInscripciones buscarPorId(Integer id);

}
