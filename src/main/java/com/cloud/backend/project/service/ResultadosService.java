package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.Resultados;

public interface ResultadosService {

	public Resultados buscarResultado(Integer id);
	public void insertarResultado(Resultados resultados);
	public void actualizarResultado(Resultados resultados);
	public void eliminarResultado(Integer id);
}
