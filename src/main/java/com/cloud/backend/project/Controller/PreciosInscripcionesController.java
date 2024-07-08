package com.cloud.backend.project.Controller;

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

import com.cloud.backend.project.repository.modelo.PreciosInscripciones;
import com.cloud.backend.project.service.IPreciosInscripcionesService;

@RestController
@CrossOrigin
@RequestMapping("/preciosInscripciones")
public class PreciosInscripcionesController {
	
	@Autowired
	private IPreciosInscripcionesService inscripcionesService;
	
	//Post
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> insertar(@RequestBody PreciosInscripciones preciosInscripciones){
		return new ResponseEntity<>(this.inscripcionesService.insertar(preciosInscripciones), null,HttpStatus.OK);
	}
	
	//Get
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PreciosInscripciones> buscarPorId(@PathVariable Integer id){
		return new ResponseEntity<>(this.inscripcionesService.buscarPorId(id), null, HttpStatus.OK);
	}
	
	
	//Put
	@PutMapping(path = "/{id}")
	public ResponseEntity<Boolean> actualizar(@PathVariable Integer id, @RequestBody PreciosInscripciones preciosInscripciones){
		preciosInscripciones.setId(id);
		return new ResponseEntity<>(this.inscripcionesService.actualizar(preciosInscripciones), null, HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable Integer id){
		return new ResponseEntity<>(this.inscripcionesService.eliminar(id),null, HttpStatus.OK);
	}
	

}
