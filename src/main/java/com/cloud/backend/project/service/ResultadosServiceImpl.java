package com.cloud.backend.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.ResultadosRepository;
import com.cloud.backend.project.repository.modelo.Resultados;

@Service
public class ResultadosServiceImpl implements ResultadosService{
	
	@Autowired
	private ResultadosRepository resultadosRepository;

	@Override
	public Resultados buscarResultado(Integer id) {
		// TODO Auto-generated method stub
		return this.resultadosRepository.buscarId(id);
	}

	@Override
	public void insertarResultado(Resultados resultados) {
		// TODO Auto-generated method stub
		this.resultadosRepository.insertar(resultados);
	}

	@Override
	public void actualizarResultado(Resultados resultados) {
		// TODO Auto-generated method stub
		this.resultadosRepository.actualizar(resultados);
	}

	@Override
	public void eliminarResultado(Integer id) {
		// TODO Auto-generated method stub
		this.resultadosRepository.eliminar(id);
	}

}
