package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.Campeonatos;
import com.cloud.backend.project.service.dto.CampeonatosDTO;
import com.cloud.backend.project.service.dto.PruebasDTO;

import java.util.*;

public interface ICampeonatosService {

    Boolean guarCampeonatos(Campeonatos campeonatos);

    List<Campeonatos> listarCampeonatos();

    Campeonatos buscarPorId(Integer id);
    CampeonatosDTO buscarPorIdDto(Integer id);

    Boolean actualizarCampeonatos(Campeonatos campeonatos);

    int borrarCampenatos(Integer id);
    
    List<CampeonatosDTO> listarCampeonatosDto();

    List<CampeonatosDTO> listarCampeonatosProvincia(String provincia);

    Boolean agregarPruebas(Integer idCampeonato, List<PruebasDTO> pruebasDTO);

    public CampeonatosDTO listarCampeonatosId(Integer id);
    
    List<CampeonatosDTO> listarSoloCampeonatosDto();

}
