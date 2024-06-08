package com.cloud.backend.project.Controller;

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

import com.cloud.backend.project.repository.modelo.Pruebas;
import com.cloud.backend.project.service.IPruebasService;

@RestController
@RequestMapping("/pruebas")
public class PruebasController {
	
	@Autowired
	private IPruebasService pruebasService;
	
	@PostMapping//(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> insertarPruebas(@RequestBody Pruebas pruebas){
		return new ResponseEntity<>(this.pruebasService.insertar(pruebas),HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")//, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> actualizarPruebas(@RequestBody Pruebas pruebas){
		boolean actualizado = this.pruebasService.actualizar(pruebas);
		return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(actualizado);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Boolean> eliminarPrueba(@PathVariable Integer id){
		boolean resultado = this.pruebasService.eliminar(id);
		return ResponseEntity.status(resultado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(resultado);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pruebas> consultarPrueba(@PathVariable Integer id){
		Pruebas pruebas = this.pruebasService.buscarPorId(id);
		return new ResponseEntity<>(pruebas,null,200);
	}

}
