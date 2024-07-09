package com.cloud.backend.project.service.dto;

import com.cloud.backend.project.repository.modelo.CompetidoresPruebas;
import com.cloud.backend.project.repository.modelo.Pruebas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetidoresPruebasDTO {
    private Integer id;
    private CompetidoresDTO competidor;
    private Pruebas prueba;

}
