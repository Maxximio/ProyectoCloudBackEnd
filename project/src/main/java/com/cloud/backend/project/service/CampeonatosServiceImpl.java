package com.cloud.backend.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.cloud.backend.project.repository.ICampeonatosRepo;
import com.cloud.backend.project.repository.modelo.Campeonatos;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CampeonatosServiceImpl implements ICampeonatosService {

    @Autowired
    private ICampeonatosRepo campeonatosRepo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Campeonatos actualizarCampeonatos(Campeonatos campeonatos) {
        // TODO Auto-generated method stub
        return this.campeonatosRepo.actualizarCampeonatos(campeonatos);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int borrarCampenatos(Integer id) {
        // TODO Auto-generated method stub
        return this.campeonatosRepo.borrarCampenatos(id);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Campeonatos buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        return this.campeonatosRepo.buscarPorId(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Campeonatos guarCampeonatos(Campeonatos campeonatos) {
        // TODO Auto-generated method stub
        return this.campeonatosRepo.guarCampeonatos(campeonatos);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Campeonatos> listarCampeonatos() {
        // TODO Auto-generated method stub
        return this.campeonatosRepo.listarCampeonatos();
    }

}
