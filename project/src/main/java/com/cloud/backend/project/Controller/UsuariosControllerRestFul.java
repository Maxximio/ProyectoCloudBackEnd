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

import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;
import com.cloud.backend.project.repository.modelo.Usuarios;
import com.cloud.backend.project.service.IDocumetosUsuariosService;
import com.cloud.backend.project.service.IUsuariosService;

//Importacion estática
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/usuarios")
public class UsuariosControllerRestFul {

    @Autowired
    private IUsuariosService usuariosService;

    @Autowired
    private IDocumetosUsuariosService docuemtosUsuariosService;
    

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuarios> consultarPorId(@PathVariable Integer id) {
        Usuarios user =  this.usuariosService.buscarPorId(id);

        return new ResponseEntity<>(user, null, 200);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuarios>> consultarTodos() {
        return new ResponseEntity<>(this.usuariosService.buscarTodosUsuarios(), null, 200);
    }


    @GetMapping(path="/{id}/documentos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DocumentosUsuarios>> consultarDocumentosPorId(@PathVariable Integer id) {

        List<DocumentosUsuarios> documentos = this.docuemtosUsuariosService.buscarDocumentosDeUsuarioDadoId(id);
        
        // for(DocumentosUsuarios dU: documentos) {
		// 	Link myLink = linkTo(methodOn(MateriaControllerRestFul.class)
		// 			.consultarPorIdTO(m.getId()))
		// 			.withSelfRel();
			
		// 	m.add(myLink);
		// }

        return new ResponseEntity<>(documentos, null, 200);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertarUsuario(@RequestBody Usuarios usuario) {
        return new ResponseEntity<>(this.usuariosService.insertar(usuario), null, HttpStatus.OK);
    }

	@PutMapping(path = "/{id}")
	public ResponseEntity<Boolean> actualizarPorId(@RequestBody Usuarios usuario, @PathVariable Integer id) {
		usuario.setId(id);
        return new ResponseEntity<>(this.usuariosService.actualizar(usuario), null, HttpStatus.OK);
	}

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> eliminarPorId(@PathVariable Integer id) {
        return new ResponseEntity<>(this.usuariosService.eliminar(id), null, HttpStatus.OK);
       
    }
    
    
    @PutMapping(path = "/estado/{id}")
	public ResponseEntity<Boolean> actualizarEstado(@PathVariable Integer id) {
        return new ResponseEntity<>(this.usuariosService.cambioEstado(id), null, HttpStatus.OK);
	}
    
    
    
    
    
}
