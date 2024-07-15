package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.ICampeonatosPruebasCompetidoresRepository;
import com.cloud.backend.project.repository.modelo.CampeonatosPruebas;
import com.cloud.backend.project.repository.modelo.CampeonatosPruebasCompetidores;
import com.cloud.backend.project.service.dto.CampeonatoPruebasCompetidoresDTO;
import com.cloud.backend.project.service.dto.CampeonatosPruebasDTO;
import com.cloud.backend.project.service.dto.CompetidoresDTO;
import com.cloud.backend.project.service.dto.PruebasDTO;
import com.cloud.backend.project.repository.modelo.Competidores;
import com.cloud.backend.project.service.dto.*;
import com.cloud.backend.project.service.dto.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampeonatosPruebasCompetidoresService implements ICampeonatosPruebasCompetidoresService{
    @Autowired
    Converter converter;
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
    public List<CampeonatoPruebasCompetidoresDTO> obtenerTodos(){
       return campeonatosPruebasCompetidoresRepository.buscarTodos().stream().map(this::convertir).toList();
    }
    public CampeonatoPruebasCompetidoresDTO convertir(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores){
        return CampeonatoPruebasCompetidoresDTO.builder().
                campeonatosPruebasId(campeonatosPruebasCompetidores.getId()).
        competidoresId(campeonatosPruebasCompetidores.getCompetidores().getId())
                .campeonatosPruebasId(campeonatosPruebasCompetidores.getCampeonatosPruebas().getId()).build();
    }
    
        @Override
        public List<CampeonatoPruebasCompetidoresLigeroDTO> obtenerCompetidoresDadoCampeonatoYPrueba(Integer idCampeonato, Integer idPrueba) {
            return campeonatosPruebasCompetidoresRepository.obtenerCompetidoresDadoCampeonatoYPrueba(idCampeonato, idPrueba).stream().map(this::convertirALigero).toList();
        }
    
        private CampeonatoPruebasCompetidoresLigeroDTO convertirALigero(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores){
    
            CampeonatoPruebasCompetidoresLigeroDTO competidorLigero = new CampeonatoPruebasCompetidoresLigeroDTO();
            competidorLigero.setId(campeonatosPruebasCompetidores.getId());
    
            Competidores competidorDatos = campeonatosPruebasCompetidores.getCompetidores();
            competidorDatos.setAsociacionesDeportivas(null);
            competidorDatos.setEstadoParticipacion(null);
            competidorDatos.setFechaInscripcion(null);
            competidorDatos.getUsuarios().setCompetidores(null);
            competidorDatos.getUsuarios().setDocumentosUsuarios(null);
            competidorDatos.getUsuarios().setPassword(null);
            competidorDatos.getUsuarios().setPassword(null);
            competidorDatos.getUsuarios().setRoles(null);
    
    
            return CampeonatoPruebasCompetidoresLigeroDTO.builder().
                    id(campeonatosPruebasCompetidores.getId()).
                    competidor(competidorDatos)
                    .build();
        }
    
}
