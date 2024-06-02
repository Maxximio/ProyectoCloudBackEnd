package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.PreciosInscripciones;

public interface IPreciosInscripcionesRepository {
	
	public Boolean insertar(PreciosInscripciones preciosInscripciones);
	public Boolean actualizar(PreciosInscripciones preciosInscripciones);
	public Boolean eliminar(Integer id);
	public PreciosInscripciones buscarPorId(Integer id);
	
}
