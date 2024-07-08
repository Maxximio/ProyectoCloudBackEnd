package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.AuthResponse;
import com.cloud.backend.project.repository.modelo.LoginRequest;
import com.cloud.backend.project.repository.modelo.RegistroRequest;

public interface IAuthService {

    AuthResponse loginUsuario(LoginRequest loginRequest);
    Integer registroUsuarioAtleta(RegistroRequest registroRequest);
    Boolean cambiarContrasenia(String correoElectronico, String nuveaContrasenia);

}
