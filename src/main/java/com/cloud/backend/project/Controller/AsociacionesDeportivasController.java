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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.backend.project.repository.modelo.AsociacionesDeportivas;
import com.cloud.backend.project.service.IAsociacionesDeportivasService;

@RestController
@CrossOrigin
@RequestMapping(path = "/asociacionesDeportivas")
public class AsociacionesDeportivasController {

	@Autowired
	private IAsociacionesDeportivasService asociacionesDeportivasService;

	// POST
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public boolean ingresar(@RequestBody AsociacionesDeportivas asociacionesDeportivas) {
		return this.asociacionesDeportivasService.insertar(asociacionesDeportivas);
	}
    

	// GET
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AsociacionesDeportivas> buscarPorID(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.asociacionesDeportivasService.buscarPorId(id));
	}

	// PUT
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean actualizar(@RequestBody AsociacionesDeportivas asociacionesDeportivas, @PathVariable Integer id) {
		asociacionesDeportivas.setId(id);
		return this.asociacionesDeportivasService.actualizar(asociacionesDeportivas);
	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	public Boolean eliminar(@PathVariable Integer id) {
		return this.asociacionesDeportivasService.eliminar(id);
	}

}
