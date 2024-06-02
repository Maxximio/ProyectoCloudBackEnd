package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Competidores;

public interface ICompetidoresRepository {

    public Boolean insertar(Competidores competidores);
	public Boolean actualizar(Competidores competidores);
	public Boolean eliminar(Integer id);
	public Competidores buscarPorId(Integer id);
    
} 
