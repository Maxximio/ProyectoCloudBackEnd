package com.cloud.backend.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.IPreciosInscripcionesRepository;
import com.cloud.backend.project.repository.modelo.PreciosInscripciones;

@Service
public class PreciosInscripcionesServiceImpl implements IPreciosInscripcionesService {

	@Autowired
	private IPreciosInscripcionesRepository preciosInscripcionesRepository;
	
	@Override
	public Boolean insertar(PreciosInscripciones preciosInscripciones) {
		// TODO Auto-generated method stub
		return preciosInscripcionesRepository.insertar(preciosInscripciones);
	}

	@Override
	public Boolean actualizar(PreciosInscripciones preciosInscripciones) {
		// TODO Auto-generated method stub
		return preciosInscripcionesRepository.actualizar(preciosInscripciones);
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return preciosInscripcionesRepository.eliminar(id);
	}

	@Override
	public PreciosInscripciones buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return preciosInscripcionesRepository.buscarPorId(id);
	}

}
