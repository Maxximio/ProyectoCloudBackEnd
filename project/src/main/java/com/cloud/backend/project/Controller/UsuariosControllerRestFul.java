package com.cloud.backend.project.Controller;

import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;
import com.cloud.backend.project.repository.modelo.Usuarios;
import com.cloud.backend.project.service.IDocumetosUsuariosService;
import com.cloud.backend.project.service.IRolesService;
import com.cloud.backend.project.service.IUsuariosService;
import com.cloud.backend.project.service.dto.ConsultaTipoDocDTO;
import com.cloud.backend.project.service.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Importacion estática
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@CrossOrigin
@RequestMapping("/usuarios")
public class UsuariosControllerRestFul {

    @Autowired
    private IUsuariosService usuariosService;

    @Autowired
    private IDocumetosUsuariosService docuemtosUsuariosService;
    
    @Autowired
    private IRolesService rolesService;

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
    public ResponseEntity<Integer> insertarUsuario(@RequestBody Usuarios usuario) {
        var roles = this.rolesService.buscar(5);
        System.out.println(roles);
       // usuario.setRoles(roles);
       // return new ResponseEntity<>(this.usuariosService.insertar(usuario), null, HttpStatus.OK);
       return null;
    }

	@PutMapping(path = "/{id}")
	public ResponseEntity<Boolean> actualizarPorId(@RequestBody Usuarios usuario, @PathVariable Integer id) {
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

    @PutMapping(path = "/estado/valor/{id}")
    public ResponseEntity<Boolean> actualizarEstadoPorValor(@PathVariable Integer id,@RequestParam String valor) {
        return new ResponseEntity<>(this.usuariosService.cambioEstado(id,valor), null, HttpStatus.OK);
    }

    //metodo para filtrar los usuarios de una provincia
    @GetMapping(path = "/prov-reg/{provincia}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuarios>> listarPorProvinciaEstadoRegTrue(@PathVariable(name="provincia")String provincia){
        return new ResponseEntity<>(this.usuariosService.listarCiudadPorEstadoReg(provincia, true),null,HttpStatus.OK);
    }

    @GetMapping(path = "/prov-noreg/{provincia}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuarios>> listarPorProvinciaEstadoRegfalse(@PathVariable(name="provincia")String provincia){
        return new ResponseEntity<>(this.usuariosService.listarCiudadPorEstadoReg(provincia, false),null,HttpStatus.OK);
    }

    @GetMapping(path = "/tipoD",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDTO>> listarPorProvinciaPorTipoDoc(@RequestBody ConsultaTipoDocDTO tipo){

        return new ResponseEntity<>(this.usuariosService.listarCiudadPorTipoDocumento(tipo.getEstado(), tipo.getTipo()),null,HttpStatus.OK);
    }
}
