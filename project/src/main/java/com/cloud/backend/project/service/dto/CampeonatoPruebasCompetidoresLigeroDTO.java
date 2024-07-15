package com.cloud.backend.project.service.dto;

import com.cloud.backend.project.repository.modelo.Competidores;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampeonatoPruebasCompetidoresLigeroDTO {

    private Integer id;
    private Competidores competidor;
}
