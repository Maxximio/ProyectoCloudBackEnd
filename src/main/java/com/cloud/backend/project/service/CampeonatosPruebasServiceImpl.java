package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.ICampeonatosPruebas;
import com.cloud.backend.project.repository.modelo.CampeonatosPruebas;
import com.cloud.backend.project.service.dto.CampeonatosPruebasDTO;
import com.cloud.backend.project.service.dto.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampeonatosPruebasServiceImpl implements ICampeonatosPruebasService{
    @Autowired
    private ICampeonatosPruebas campeonatosPruebasRepository;
    @Autowired
    private Converter converter;


    @Override
    public Boolean insertar(CampeonatosPruebas campeonatosPruebas) {
        return this.campeonatosPruebasRepository.insertar(campeonatosPruebas);
    }

    @Override
    public CampeonatosPruebas buscarPorId(Integer id) {
        return this.campeonatosPruebasRepository.buscarPorId(id);
    }

    @Override
    public CampeonatosPruebasDTO buscarPorIdDto(Integer id) {
        CampeonatosPruebas campeonatosPruebas=this.buscarPorId(id);

        return converter.covertToDto(campeonatosPruebas);
    }

    @Override
    public List<CampeonatosPruebasDTO> filtrarCampeonato(Integer idCampeonato) {
        // TODO Auto-generated method stub
        List<CampeonatosPruebas> campeonatosPruebas = this.campeonatosPruebasRepository.buscarPorIdCampeonatos(idCampeonato);
        List<CampeonatosPruebasDTO> campeonatosPruebasDTOS=campeonatosPruebas.stream().map(x -> converter.covertToDto(x)).collect(Collectors.toList());
        return campeonatosPruebasDTOS;
    }

    @Override
    public Boolean actualizar(CampeonatosPruebas campeonatosPruebas) {
        return this.campeonatosPruebasRepository.actualizar(campeonatosPruebas);
    }

    @Override
    public Boolean eliminar(Integer id) {
        return this.campeonatosPruebasRepository.eliminar(id);
    }

    @Override
    public List<CampeonatosPruebasDTO> obtenerTodos() {
        return null;
       // return this.campeonatosPruebasRepository.obtenerTodos().stream().map(this::converter.).collect(Collectors.toList());
    }

}
