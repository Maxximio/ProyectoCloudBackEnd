package com.cloud.backend.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.cloud.backend.project.repository.modelo.Categorias;
import com.cloud.backend.project.service.ICategoriasService;
@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private ICategoriasService categoriasService;
	
	//Post
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> guardar(@RequestBody Categorias categorias) {
		return new ResponseEntity<>(this.categoriasService.insertar(categorias), null, HttpStatus.OK);
	}
	
	
	//Get
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categorias> consultarPorId(@PathVariable Integer id) {
		
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("detalles", "Categoria encontrada exitosamente");
		
		return new ResponseEntity<>(this.categoriasService.buscarPorId(id),cabeceras, HttpStatus.OK);
	}
	
	//Put
	@PutMapping(path = "/{id}")
	public ResponseEntity<Boolean> actualizar(@RequestBody Categorias categorias, @PathVariable Integer id) {
		categorias.setId(id);
		return new ResponseEntity<>(this.categoriasService.actualizar(categorias), null, HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable Integer id) {
		return new ResponseEntity<>(this.categoriasService.eliminar(id), null, HttpStatus.OK);
	}

}
