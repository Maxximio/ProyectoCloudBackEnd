package com.cloud.backend.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cloud.backend.project.repository.modelo.AuthResponse;
import com.cloud.backend.project.repository.modelo.LoginRequest;
import com.cloud.backend.project.repository.modelo.RegistroRequest;
import com.cloud.backend.project.service.IAuthService;

@RestController
@CrossOrigin
@RequestMapping(path = "/auth")
public class AuthRestFullController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUsuario(@RequestBody LoginRequest loginRequest) {
        try {
            AuthResponse response = authService.loginUsuario(loginRequest);
            if (response != null) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<Integer> registroUsuarioAtleta(@RequestBody RegistroRequest registroRequest) {
        Integer id = authService.registroUsuarioAtleta(registroRequest);
        if (id != 0) {
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(id);
        }
    }


    @PutMapping("/recuperarPass")
    public ResponseEntity<Boolean> recuperarContrasenia(@PathVariable String correo, @RequestParam String password) {
        Boolean cambio = authService.cambiarContrasenia(correo, password);
        if (cambio) {
            return ResponseEntity.ok(cambio);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cambio);
        }
    }
    /*@PostMapping("/registro")
    public ResponseEntity<String> registroUsuarioAtleta(@RequestBody RegistroRequest registroRequest) {
        Boolean registroExitoso = authService.registroUsuarioAtleta(registroRequest);
        if (registroExitoso) {
            return ResponseEntity.ok("Usuario registrado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al registrar usuario");
        }
    }*/
}
