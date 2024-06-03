package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.Campeonatos;

import java.util.*;

public interface ICampeonatosService {

    Campeonatos guarCampeonatos(Campeonatos campeonatos);

    List<Campeonatos> listarCampeonatos();

    Campeonatos buscarPorId(Integer id);

    Campeonatos actualizarCampeonatos(Campeonatos campeonatos);


    int borrarCampenatos(Integer id);

}
