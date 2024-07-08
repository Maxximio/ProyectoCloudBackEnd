package com.cloud.backend.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.IPruebasRepository;
import com.cloud.backend.project.repository.modelo.Pruebas;

import java.util.List;

@Service
public class PruebasServiceImpl implements IPruebasService{
	
	@Autowired
	private IPruebasRepository pruebasRepository;

	@Override
	public Boolean insertar(Pruebas pruebas) {
		// TODO Auto-generated method stub
		return this.pruebasRepository.insertar(pruebas);
	}

	@Override
	public Pruebas buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.pruebasRepository.buscarPorId(id);
	}

	@Override
	public Boolean actualizar(Pruebas pruebas) {
		// TODO Auto-generated method stub
		return this.pruebasRepository.actualizar(pruebas);
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return this.pruebasRepository.eliminar(id);
	}

	@Override
	public List<Pruebas> buscarTodas() {
		return this.pruebasRepository.buscarTodas();
	}

}
