package com.cloud.backend.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.IPruebasCalendariosCompetenciasRepository;
import com.cloud.backend.project.repository.modelo.PruebasCalendariosCompetencias;
@Service
public class PruebasCalendariosCompetenciasServiceImpl implements IPruebasCalendariosCompetenciasRepository{
	
	@Autowired
	private IPruebasCalendariosCompetenciasRepository pruebasCalendariosCompetenciasRepository;

	@Override
	public Boolean insertar(PruebasCalendariosCompetencias pruebasCalendariosCompetencias) {
		// TODO Auto-generated method stub
		return pruebasCalendariosCompetenciasRepository.insertar(pruebasCalendariosCompetencias);
	}

	@Override
	public Boolean actualizar(PruebasCalendariosCompetencias pruebasCalendariosCompetencias) {
		// TODO Auto-generated method stub
		return pruebasCalendariosCompetenciasRepository.actualizar(pruebasCalendariosCompetencias);
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return pruebasCalendariosCompetenciasRepository.eliminar(id);
	}

	@Override
	public PruebasCalendariosCompetencias buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return pruebasCalendariosCompetenciasRepository.buscarPorId(id);
	}

}
