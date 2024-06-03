package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Campeonatos;
import java.util.*;

public interface ICampeonatosRepo {


    Campeonatos guarCampeonatos(Campeonatos campeonatos);

    List<Campeonatos> listarCampeonatos();

    Campeonatos buscarPorId(Integer id);

    Campeonatos actualizarCampeonatos(Campeonatos campeonatos);


    int borrarCampenatos(Integer id);


}
