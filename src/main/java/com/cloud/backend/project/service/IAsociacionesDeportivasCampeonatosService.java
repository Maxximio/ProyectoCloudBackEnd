package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.AsociacionesDeportivasCampeonatos;

public interface IAsociacionesDeportivasCampeonatosService {
    
    public Boolean insertar(AsociacionesDeportivasCampeonatos asociacionesDeportivasCampeonatos);
	public Boolean actualizar(AsociacionesDeportivasCampeonatos asociacionesDeportivasCampeonatos);
	public Boolean eliminar(Integer id);
	public AsociacionesDeportivasCampeonatos buscarPorId(Integer id);

}
