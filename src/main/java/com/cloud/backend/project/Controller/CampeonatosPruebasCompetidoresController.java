package com.cloud.backend.project.Controller;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebasCompetidores;
import com.cloud.backend.project.service.ICampeonatosPruebasCompetidoresService;
import com.cloud.backend.project.service.dto.CampeonatoPruebasCompetidoresDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@CrossOrigin
@RequestMapping(path = "/campeonatosPruebasCompetidores")
public class CampeonatosPruebasCompetidoresController {

	@Autowired
	private ICampeonatosPruebasCompetidoresService campeonatosPruebasCompetidoresService;

	// POST
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public boolean ingresar(@RequestBody CampeonatosPruebasCompetidores campeonatosPruebasCompetidores) {
		return this.campeonatosPruebasCompetidoresService.insertar(campeonatosPruebasCompetidores);
	}
    

	// GET
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CampeonatosPruebasCompetidores> buscarPorID(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.campeonatosPruebasCompetidoresService.buscarPorId(id));
	}

	// PUT
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean actualizar(@RequestBody CampeonatosPruebasCompetidores campeonatosPruebasCompetidores, @PathVariable Integer id) {
		campeonatosPruebasCompetidores.setId(id);
		return this.campeonatosPruebasCompetidoresService.actualizar(campeonatosPruebasCompetidores);
	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	public Boolean eliminar(@PathVariable Integer id) {
		return this.campeonatosPruebasCompetidoresService.eliminar(id);
	}

	//GETALL
	@GetMapping
	public ResponseEntity<List<CampeonatoPruebasCompetidoresDTO>>obtenerTodo(){
		List<CampeonatoPruebasCompetidoresDTO> dtos=this.campeonatosPruebasCompetidoresService.obtenerTodos();
		dtos.forEach(dto ->
				{
					//dto.add(linkTo(methodOn(CampeonatosPruebasCompetidoresController.class).obtenerTodo()).slash(dto.getId()).withSelfRel());
					dto.add(linkTo(methodOn(CampeonatosPruebasController.class).buscarPorId(dto.getCampeonatosPruebasId())).withRel("campeonatosPruebas"));
					dto.add(linkTo(methodOn(CompetidoresController.class).consultarCompetidorPorId(dto.getCompetidoresId())).withRel("competidores"));

				})
				;
		return ResponseEntity.of(Optional.ofNullable(dtos));
	}
	//GETALL
	@GetMapping(path = "/{id}/campeonatoPrueba")
	public ResponseEntity<List<CampeonatoPruebasCompetidoresDTO>>obtenerCamepeonatoPrueba(@PathVariable Integer id){
		List<CampeonatoPruebasCompetidoresDTO> dtos=this.campeonatosPruebasCompetidoresService.obtenerTodos();
		dtos.forEach(dto ->
		{
			//dto.add(linkTo(methodOn(CampeonatosPruebasCompetidoresController.class).obtenerTodo()).slash(dto.getId()).withSelfRel());
			dto.add(linkTo(methodOn(CampeonatosPruebasController.class).buscarPorId(dto.getCampeonatosPruebasId())).withRel("campeonatosPruebas"));
			dto.add(linkTo(methodOn(CompetidoresController.class).consultarCompetidorPorId(dto.getCompetidoresId())).withRel("competidores"));

		})
		;
		return ResponseEntity.of(Optional.ofNullable(dtos));
	}
	//Con hateos


}
