package com.cloud.backend.project.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;
import com.cloud.backend.project.service.IDocumetosUsuariosService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin
@RequestMapping("/documentos/")
public class DocumentosUsuariosController {

	
	@Autowired
	private IDocumetosUsuariosService documetosUsuariosService;
	
	
	@GetMapping(path="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DocumentosUsuarios>buscarDocumentosId(@PathVariable Integer id) {
		return new ResponseEntity<>(this.documetosUsuariosService.buscarDocumentos(id),null,200);
	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> insertarDocumento(@RequestBody DocumentosUsuarios documentos) {
        return new ResponseEntity<>(this.documetosUsuariosService.insertarDocumentos(documentos), null, HttpStatus.OK);
    }

	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> actualizarDocumento(@RequestBody DocumentosUsuarios documento) {
        boolean actualizado = this.documetosUsuariosService.actualizarDocumentos(documento);
        return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(actualizado);
    }
   
    
    
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> eliminarDocumentoPorId(@PathVariable Integer id) {
        boolean resultado = this.documetosUsuariosService.eliminarDocumentos(id);
        return ResponseEntity.status(resultado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(resultado);
    }
    
    @GetMapping(path="usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DocumentosUsuarios>>buscarDocumentosPorUsuarioId(@PathVariable Integer id) {
		return new ResponseEntity<>(this.documetosUsuariosService.buscarDocumentosDeUsuarioDadoId(id),null,200);
	}
    

	
}
