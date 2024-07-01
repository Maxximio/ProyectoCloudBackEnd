package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.ICampeonatosPruebasCompetidoresRepository;
import com.cloud.backend.project.repository.modelo.CampeonatosPruebasCompetidores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampeonatosPruebasCompetidoresService implements ICampeonatosPruebasCompetidoresService{
    
    @Autowired
	private ICampeonatosPruebasCompetidoresRepository campeonatosPruebasCompetidoresRepository;

    @Override
    public Boolean insertar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores) {
       return campeonatosPruebasCompetidoresRepository.insertar(campeonatosPruebasCompetidores);
    }

    @Override
    public Boolean actualizar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores) {
       return campeonatosPruebasCompetidoresRepository.actualizar(campeonatosPruebasCompetidores);
    }

    @Override
    public Boolean eliminar(Integer id) {
       return campeonatosPruebasCompetidoresRepository.eliminar(id);
    }

    @Override
    public CampeonatosPruebasCompetidores buscarPorId(Integer id) {
        return campeonatosPruebasCompetidoresRepository.buscarPorId(id);
    }

}
