package com.cloud.backend.project.Controller;

import com.cloud.backend.project.repository.modelo.Roles;

import com.cloud.backend.project.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Roles> consultarPorId(@PathVariable Integer id) {
        Roles roles =  this.rolesService.buscar(id);

        return new ResponseEntity<>(roles, null, 200);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Roles>> consultarTodos() {
        return new ResponseEntity<>(this.rolesService.buscarTodosRoles(), null, 200);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertarRol(@RequestBody Roles roles) {
        return new ResponseEntity<>(this.rolesService.insertarRol(roles), null, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Boolean> actualizarPorId(@RequestBody Roles roles, @PathVariable Integer id) {
        roles.setId(id);
        return new ResponseEntity<>(this.rolesService.actualizarRol(roles), null, HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> eliminarPorId(@PathVariable Integer id) {
        return new ResponseEntity<>(this.rolesService.eliminarRol(id), null, HttpStatus.OK);

    }
}
