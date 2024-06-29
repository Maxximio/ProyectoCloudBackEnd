package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.Campeonatos;
import com.cloud.backend.project.service.dto.CampeonatosDTO;
import com.cloud.backend.project.service.dto.PruebasDTO;

import java.util.*;

public interface ICampeonatosService {

    Boolean guarCampeonatos(Campeonatos campeonatos);

    List<Campeonatos> listarCampeonatos();

    Campeonatos buscarPorId(Integer id);

    Boolean actualizarCampeonatos(Campeonatos campeonatos);

    int borrarCampenatos(Integer id);
    
    List<CampeonatosDTO> listarCampeonatosDto();

    Boolean agregarPruebas(Integer idCampeonato, List<PruebasDTO> pruebasDTO);

}
