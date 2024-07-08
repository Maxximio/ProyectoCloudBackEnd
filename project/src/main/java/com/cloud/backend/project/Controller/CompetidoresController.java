package com.cloud.backend.project.Controller;

import com.cloud.backend.project.service.dto.CompetidoresDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.backend.project.repository.modelo.Competidores;
import com.cloud.backend.project.service.ICompetidoresService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/competidores")
public class CompetidoresController {
	
	@Autowired
	private ICompetidoresService competidoresService;
	
	
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertarCompetidor(@RequestBody Competidores competidores) {
        return new ResponseEntity<>(this.competidoresService.insertar(competidores), null, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/id")
    public ResponseEntity<Integer> insertarCompetidorId(@RequestBody Competidores competidores) {
        return new ResponseEntity<>(this.competidoresService.insertarId(competidores), null, HttpStatus.OK);
    }
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> actualizarCompetidor(@RequestBody Competidores Competidores) {
        boolean actualizado = this.competidoresService.actualizar(Competidores);
        return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(actualizado);
    }
   
    
    
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> eliminarCompetidorPorId(@PathVariable Integer id) {
        boolean resultado = this.competidoresService.eliminar(id);
        return ResponseEntity.status(resultado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(resultado);
    }
    
    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompetidoresDTO> consultarCompetidorPorId(@PathVariable Integer id) {
        CompetidoresDTO competidor =  this.competidoresService.buscarPorIdDto(id);

        return new ResponseEntity<>(competidor, null, 200);
    }

    
   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Competidores>> consultarCampeonatos() {
       return new ResponseEntity<>(this.competidoresService.listarCompetidores(), null, 200);
    }
    

}
