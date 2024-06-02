package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.CampeonatosCompetidores;

public interface ICampeonatosCompetidoresRepository {
	
	public Boolean insertar(CampeonatosCompetidores campeonatosCompetidores);
	public CampeonatosCompetidores buscarPorId(Integer id);
	public Boolean actualizar(CampeonatosCompetidores campeonatosCompetidores);
	public Boolean eliminar(Integer id);

}
