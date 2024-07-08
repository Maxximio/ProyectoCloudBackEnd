package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.PruebasCalendariosCompetencias;

public interface IPruebasCalendariosCompetenciasRepository {
	
	public Boolean insertar(PruebasCalendariosCompetencias pruebasCalendariosCompetencias);
	public Boolean actualizar(PruebasCalendariosCompetencias pruebasCalendariosCompetencias);
	public Boolean eliminar(Integer id);
	public PruebasCalendariosCompetencias buscarPorId(Integer id);

}
