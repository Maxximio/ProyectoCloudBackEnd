package com.cloud.backend.project.service;

import java.util.List;

import com.cloud.backend.project.repository.modelo.Competidores;
import com.cloud.backend.project.service.dto.CompetidoresDTO;
import com.cloud.backend.project.service.dto.CompetidoresEstadoDTO;

public interface ICompetidoresService {
    
    public Boolean insertar(Competidores competidores);
    public Integer insertarId(Competidores competidores);
	public Boolean actualizar(Competidores competidores);
	public Boolean eliminar(Integer id);
	public Competidores buscarPorId(Integer id);
	public CompetidoresDTO buscarPorIdDto(Integer id);
	List<Competidores> listarCompetidores();
	List<CompetidoresDTO> listarCompetidoresDTO();

	public Boolean actualizarEstado(Integer id, String nuevoEstado);
	public List<CompetidoresEstadoDTO> listarCompetidoresPorEstadoYCiudad(Boolean estado, String estadoParticipacion, String ciudad);


}
