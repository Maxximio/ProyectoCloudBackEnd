package com.cloud.backend.project.Controller;

import com.cloud.backend.project.repository.modelo.CompetidoresPruebas;
import com.cloud.backend.project.service.ICompetidoresPruebasService;
import com.cloud.backend.project.service.dto.CompetidoresDTO;
import com.cloud.backend.project.service.dto.CompetidoresPruebasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/competidoresPruebas")
public class CompetidoresPruebasController {
    @Autowired
    private ICompetidoresPruebasService competidoresPruebasService;

    // POST
    @PostMapping(consumes = "application/json")
    public boolean insertar(@RequestBody CompetidoresPruebas competidoresPruebas) {
        return this.competidoresPruebasService.insertar(competidoresPruebas);
    }

    // GET
    @GetMapping(path = "/{id}", produces = "application/json")
    public CompetidoresPruebas buscarPorId(@PathVariable Integer id) {
        return this.competidoresPruebasService.buscarPorId(id);
    }

    // PUT
    @PutMapping(path = "/{id}", consumes = "application/json")
    public Boolean actualizar(@RequestBody CompetidoresPruebas competidoresPruebas, @PathVariable Integer id) {
        competidoresPruebas.setId(id);
        return this.competidoresPruebasService.actualizar(competidoresPruebas);
    }

    // DELETE
    @DeleteMapping(path = "/{id}")
    public Boolean eliminar(@PathVariable Integer id) {
        return this.competidoresPruebasService.eliminar(id);
    }

    //GETALL
    @GetMapping
    public ResponseEntity<HashMap<String,List<CompetidoresDTO>>> obtenerTodo(){
        HashMap<String,List<CompetidoresDTO>> dtos=this.competidoresPruebasService.obtenerTodosDTO();
        return ResponseEntity.of(Optional.ofNullable(dtos));
    }
}
