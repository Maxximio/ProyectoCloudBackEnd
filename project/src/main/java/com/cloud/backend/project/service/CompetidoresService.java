package com.cloud.backend.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.ICompetidoresRepository;
import com.cloud.backend.project.repository.modelo.Competidores;

@Service
public class CompetidoresService implements ICompetidoresService{
    
    @Autowired
	private ICompetidoresRepository competidoresRepository;

    @Override
    public Boolean insertar(Competidores competidores) {
        return competidoresRepository.insertar(competidores);
    }

    @Override
    public Boolean actualizar(Competidores competidores) {
        return competidoresRepository.actualizar(competidores);
    }

    @Override
    public Boolean eliminar(Integer id) {
        return competidoresRepository.eliminar(id);
    }

    @Override
    public Competidores buscarPorId(Integer id) {
        return competidoresRepository.buscarPorId(id);
    }



}
