package com.cloud.backend.project.service.dto;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebas;
import com.cloud.backend.project.repository.modelo.Pruebas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampeonatoPruebasCompetidoresDTO extends RepresentationModel<CampeonatoPruebasCompetidoresDTO> {
    private Integer id;
    private Integer campeonatosPruebasId;
    private Integer competidoresId;
}
