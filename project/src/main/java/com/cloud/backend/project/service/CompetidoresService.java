package com.cloud.backend.project.service;

import java.util.List;
import java.util.stream.Collectors;

import com.cloud.backend.project.service.dto.CompetidoresDTO;
import com.cloud.backend.project.service.dto.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.ICompetidoresRepository;
import com.cloud.backend.project.repository.modelo.Competidores;

@Service
public class CompetidoresService implements ICompetidoresService{
    
    @Autowired
	private ICompetidoresRepository competidoresRepository;
    @Autowired
    private Converter converter;

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

    @Override
    public CompetidoresDTO buscarPorIdDto(Integer id) {
        Competidores comp=this.buscarPorId(id);
        if(comp!=null){
            CompetidoresDTO dto=new CompetidoresDTO();
            dto.setId(comp.getId());
            dto.setFechaInscripcion(comp.getFechaInscripcion());
            dto.setCuentaBancaria(comp.getCuentaBancaria());
            dto.setUsuarios(converter.covertToDto(comp.getUsuarios()));
            dto.setAsociacionesDeportivas(comp.getAsociacionesDeportivas());
            return dto;
        }
        return null;
    }

    @Override
	public List<Competidores> listarCompetidores() {
		// TODO Auto-generated method stub
		return competidoresRepository.listarCompetidores();
	}

    @Override
    public List<CompetidoresDTO> listarCompetidoresDTO() {
        List<Competidores> competidores = this.listarCompetidores();
        List<CompetidoresDTO> competidoresDTOS = competidores.stream().map(x -> converter.covertToDto(x)).collect(Collectors.toList());
        return competidoresDTOS;
    }




}
