package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.PruebasCalendariosCompetencias;

public interface IPruebasCalendariosCompetenciasService {
	
	public Boolean insertar(PruebasCalendariosCompetencias pruebasCalendariosCompetencias);
	public Boolean actualizar(PruebasCalendariosCompetencias pruebasCalendariosCompetencias);
	public Boolean eliminar(Integer id);
	public PruebasCalendariosCompetencias buscarPorId(Integer id);

}
