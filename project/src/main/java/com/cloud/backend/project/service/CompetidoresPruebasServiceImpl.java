package com.cloud.backend.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.ICompetidoresPruebasRepository;
import com.cloud.backend.project.repository.modelo.CompetidoresPruebas;

@Service
public class CompetidoresPruebasServiceImpl implements ICompetidoresPruebasService{
	
	@Autowired
	private ICompetidoresPruebasRepository competidoresPruebasRepository;

	@Override
	public Boolean insertar(CompetidoresPruebas competidoresPruebas) {
		// TODO Auto-generated method stub
		return this.competidoresPruebasRepository.insertar(competidoresPruebas);
	}

	@Override
	public CompetidoresPruebas buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.competidoresPruebasRepository.buscarPorId(id);
	}

	@Override
	public Boolean actualizar(CompetidoresPruebas competidoresPruebas) {
		// TODO Auto-generated method stub
		return this.competidoresPruebasRepository.actualizar(competidoresPruebas);
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return this.competidoresPruebasRepository.eliminar(id);
	}
	
	

}
