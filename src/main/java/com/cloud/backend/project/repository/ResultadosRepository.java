package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Resultados;

public interface ResultadosRepository {

	public Resultados buscarId(Integer id);
	public void insertar(Resultados resultados);
	public void actualizar(Resultados resultados);
	public void eliminar(Integer id);
}
