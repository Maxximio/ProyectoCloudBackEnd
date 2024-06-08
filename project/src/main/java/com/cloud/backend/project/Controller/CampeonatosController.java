package com.cloud.backend.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.backend.project.repository.modelo.Campeonatos;
import com.cloud.backend.project.service.ICampeonatosService;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatosController {
    
    @Autowired
    private ICampeonatosService campeonatosService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertarCampeonato(@RequestBody Campeonatos campeonatos) {
        try{
            return new ResponseEntity<>(this.campeonatosService.guarCampeonatos(campeonatos), null, HttpStatus.OK);
        }catch(RuntimeException ex){
            return ResponseEntity.badRequest().build();
        }
        
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Campeonatos>> consultarCampeonatos() {
        try{
            return new ResponseEntity<>(this.campeonatosService.listarCampeonatos(), null, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
       
    }

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Campeonatos> consultarCampeonatosPorId(@PathVariable Integer id) {
        Campeonatos campeonatos =  this.campeonatosService.buscarPorId(id);

        return new ResponseEntity<>(campeonatos, null, HttpStatus.OK);
    }

    @PutMapping(path = "/")
	public ResponseEntity<Boolean> actualizarCampeonato(@RequestBody Campeonatos campeonatos) {
        //return new ResponseEntity<>(this.campeonatosService.actualizarCampeonatos(campeonatos), null, HttpStatus.OK);
        boolean actualizado = this.campeonatosService.actualizarCampeonatos(campeonatos);
        return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(actualizado);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> eliminarCampeonatoPorId(@PathVariable Integer id) {
        try{
            int resultado = this.campeonatosService.borrarCampenatos(id);
            boolean eliminado = resultado == 1;
            return ResponseEntity.status(eliminado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(eliminado);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }  
    }

}
