package com.cloud.backend.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.IAsociacionesDeportivasCampeonatosRepository;
import com.cloud.backend.project.repository.modelo.AsociacionesDeportivasCampeonatos;

@Service
public class AsociacionesDeportivasCampeonatosService implements IAsociacionesDeportivasCampeonatosService{
    
    @Autowired
	private IAsociacionesDeportivasCampeonatosRepository asociacionesDeportivasCampeonatosRepository;

    @Override
    public Boolean insertar(AsociacionesDeportivasCampeonatos asociacionesDeportivasCampeonatos) {
       return asociacionesDeportivasCampeonatosRepository.insertar(asociacionesDeportivasCampeonatos);
    }

    @Override
    public Boolean actualizar(AsociacionesDeportivasCampeonatos asociacionesDeportivasCampeonatos) {
       return asociacionesDeportivasCampeonatosRepository.actualizar(asociacionesDeportivasCampeonatos);
    }

    @Override
    public Boolean eliminar(Integer id) {
       return asociacionesDeportivasCampeonatosRepository.eliminar(id);
    }

    @Override
    public AsociacionesDeportivasCampeonatos buscarPorId(Integer id) {
        return asociacionesDeportivasCampeonatosRepository.buscarPorId(id);
    }

}
