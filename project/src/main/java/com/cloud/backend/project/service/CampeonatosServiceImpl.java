package com.cloud.backend.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.cloud.backend.project.repository.ICampeonatosRepo;
import com.cloud.backend.project.repository.modelo.Campeonatos;
import com.cloud.backend.project.repository.modelo.CampeonatosPruebas;
import com.cloud.backend.project.service.dto.CampeonatosDTO;
import com.cloud.backend.project.service.dto.PruebasDTO;

import org.springframework.transaction.annotation.Transactional;

@Service
public class CampeonatosServiceImpl implements ICampeonatosService {

    @Autowired
    private ICampeonatosRepo campeonatosRepo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean actualizarCampeonatos(Campeonatos campeonatos) {
        return this.campeonatosRepo.actualizarCampeonatos(campeonatos);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int borrarCampenatos(Integer id) {
        return this.campeonatosRepo.borrarCampenatos(id);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Campeonatos buscarPorId(Integer id) {
        return this.campeonatosRepo.buscarPorId(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean guarCampeonatos(Campeonatos campeonatos) {
        return this.campeonatosRepo.guarCampeonatos(campeonatos);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Campeonatos> listarCampeonatos() {
        return this.campeonatosRepo.listarCampeonatos();
    }

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<CampeonatosDTO> listarCampeonatosDto() {
		// TODO Auto-generated method stub
		return campeonatosRepo.listarCampeonatos().stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	private CampeonatosDTO convertToDto(Campeonatos campeonato) {
        CampeonatosDTO dto = new CampeonatosDTO();
        dto.setId(campeonato.getId());
        dto.setNombre(campeonato.getNombre());
        dto.setOrganizador(campeonato.getOrganizador());
        dto.setSede(campeonato.getSede());
        dto.setFechaInicio(campeonato.getFechaInicio());
        dto.setInscripcionInicio(campeonato.getInscripcionInicio());
        dto.setInscripcionFin(campeonato.getInscripcionFin());

        List<PruebasDTO> pruebas = campeonato.getCampeonatosPruebas().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        dto.setPruebas(pruebas);

        return dto;
    }
	
	private PruebasDTO convertToDto(CampeonatosPruebas campeonatosPruebas) {
        PruebasDTO dto = new PruebasDTO();
        dto.setId(campeonatosPruebas.getPruebas().getId());
        dto.setNombre(campeonatosPruebas.getPruebas().getNombre());
        dto.setIntentos(campeonatosPruebas.getPruebas().getIntentos());
        dto.setTipo(campeonatosPruebas.getPruebas().getTipo());
        dto.setCategoria(campeonatosPruebas.getPruebas().getCategoria());
        return dto;
    }

}
