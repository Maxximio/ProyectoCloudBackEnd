package com.cloud.backend.project.Controller;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebas;
import com.cloud.backend.project.service.ICampeonatosPruebasService;
import com.cloud.backend.project.service.dto.CampeonatosPruebasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(path = "/campeonatosPruebas")
public class CampeonatosPruebasController {
    @Autowired
    private ICampeonatosPruebasService campeonatosPruebasService;

    // POST
    @PostMapping(consumes = "application/json")
    public boolean insertar(@RequestBody CampeonatosPruebas campeonatosPruebas) {
        return this.campeonatosPruebasService.insertar(campeonatosPruebas);
    }

    // GET
    @GetMapping(path = "/{id}", produces = "application/json")
    public CampeonatosPruebasDTO buscarPorId(@PathVariable Integer id) {
        CampeonatosPruebasDTO dto = this.campeonatosPruebasService.buscarPorIdDto(id);
        dto.add(linkTo(methodOn(CampeonatosController.class).consultarCampeonatosIdDto(dto.getCampeonatoId())).withRel("campeonato"));
        dto.add(linkTo(methodOn(PruebasController.class).consultarPrueba(dto.getPruebaId())).withRel("prueba"));
        return dto;
    }

    // PUT
    @PutMapping(path = "/{id}", consumes = "application/json")
    public Boolean actualizar(@RequestBody CampeonatosPruebas campeonatosPruebas, @PathVariable Integer id) {
        campeonatosPruebas.setId(id);
        return this.campeonatosPruebasService.actualizar(campeonatosPruebas);
    }

    // DELETE
    @DeleteMapping(path = "/{id}")
    public Boolean eliminar(@PathVariable Integer id) {
        return this.campeonatosPruebasService.eliminar(id);
    }

    //GETALL
    @GetMapping
    public ResponseEntity<List<CampeonatosPruebasDTO>> obtenerTodo(){
        List<CampeonatosPruebasDTO> dtos=this.campeonatosPruebasService.obtenerTodos();
        return ResponseEntity.of(Optional.ofNullable(dtos));
    }
    //Filtrar
    @GetMapping(path = "/{campeonatoId}/campeonato")
    public ResponseEntity<List<CampeonatosPruebasDTO>> filtrar(@PathVariable Integer campeonatoId)
    {
        List<CampeonatosPruebasDTO> dtos=this.campeonatosPruebasService.filtrarCampeonato(campeonatoId);
        dtos.forEach(dto -> {

            dto.add(linkTo(methodOn(CampeonatosController.class).consultarCampeonatosIdDto(dto.getCampeonatoId())).withRel("campeonato"));
            dto.add(linkTo(methodOn(PruebasController.class).consultarPrueba(dto.getPruebaId())).withRel("prueba"));
        });

        return ResponseEntity.of(Optional.ofNullable(dtos));
    }
}
