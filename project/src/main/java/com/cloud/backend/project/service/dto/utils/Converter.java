package com.cloud.backend.project.service.dto.utils;

import com.cloud.backend.project.repository.modelo.*;
import com.cloud.backend.project.service.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {
    public CampeonatosDTO convertToDto(Campeonatos campeonato) {

        List<PruebasDTO> pruebas = campeonato.getCampeonatosPruebas().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());


        return CampeonatosDTO.builder()
                .id(campeonato.getId())
                .nombre(campeonato.getNombre())
                .organizador(campeonato.getOrganizador())
                .sede(campeonato.getSede())
                .fechaInicio(campeonato.getFechaInicio())
                .inscripcionInicio(campeonato.getInscripcionInicio())
                .inscripcionFin(campeonato.getInscripcionFin())
                .pruebas(pruebas)
                .build();


    }

    public PruebasDTO convertToDto(CampeonatosPruebas campeonatosPruebas) {
        PruebasDTO dto = new PruebasDTO();
        dto.setId(campeonatosPruebas.getPruebas().getId());
        dto.setNombre(campeonatosPruebas.getPruebas().getNombre());
        dto.setIntentos(campeonatosPruebas.getPruebas().getIntentos());
        dto.setTipo(campeonatosPruebas.getPruebas().getTipo());
        dto.setCategoria(campeonatosPruebas.getPruebas().getCategoria());
        return dto;
    }
    public CompetidoresDTO covertToDto(Competidores competidores){
        CompetidoresDTO dto=new CompetidoresDTO();
        if(competidores!=null){
            dto.setId(competidores.getId());
            dto.setFechaInscripcion(competidores.getFechaInscripcion());
            dto.setCuentaBancaria(competidores.getEstadoParticipacion());
            dto.setUsuarios(this.covertToDto(competidores.getUsuarios()));
            dto.setAsociacionesDeportivas(competidores.getAsociacionesDeportivas());
           // dto.setUsuarios(competidores.getUsuarios());
        }


        return dto;
    }
    public UsuarioDTO covertToDto(Usuarios usuarios){
        UsuarioDTO dto=new UsuarioDTO();
        if(usuarios!=null){
            dto.setId(usuarios.getId());
            dto.setNombres(usuarios.getNombres());
            dto.setApellidos(usuarios.getApellidos());
            dto.setCiudad(usuarios.getCiudad());
            dto.setEmail(usuarios.getEmail());
            dto.setTelefono(usuarios.getTelefono());
            dto.setFechaNacimiento(usuarios.getFechaNacimiento());
            dto.setSexo(usuarios.getSexo());
            dto.setEstado(usuarios.getEstado());
            dto.setFechaSuscripción(usuarios.getFechaSuscripción());
            dto.setDocumento(usuarios.getDocumentosUsuarios());
        }


        return dto;
    }
    public CampeonatosPruebasDTO covertToDto(CampeonatosPruebas campeonatosPruebas){
        CampeonatosPruebasDTO dto=new CampeonatosPruebasDTO();
        if(campeonatosPruebas!=null){
            dto.setId(campeonatosPruebas.getId());
            //dto.setCampeonatoId(campeonatosPruebas.getCampeonatos().getId());
            //dto.setPruebaId(campeonatosPruebas.getPruebas().getId());
        }


        return dto;
    }
    public CompetidoresPruebasDTO covertToDto(CompetidoresPruebas competidoresPruebas){
        CompetidoresPruebasDTO dto=new CompetidoresPruebasDTO();

        if(competidoresPruebas!=null){
            dto.setId(competidoresPruebas.getId());
            dto.setCompetidor(this.covertToDto(competidoresPruebas.getCompetidores()));
            dto.setPrueba((competidoresPruebas.getPruebas()));
        }


        return dto;
    }
}
