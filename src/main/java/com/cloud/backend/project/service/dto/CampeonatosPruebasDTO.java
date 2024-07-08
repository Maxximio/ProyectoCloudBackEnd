package com.cloud.backend.project.service.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampeonatosPruebasDTO extends RepresentationModel<CampeonatosPruebasDTO> {
    private Integer id;
    private Integer campeonatoId;
   private Integer pruebaId;
}
