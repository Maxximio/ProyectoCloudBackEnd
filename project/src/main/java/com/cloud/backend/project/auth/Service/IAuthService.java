package com.cloud.backend.project.auth.Service;

import com.cloud.backend.project.auth.Modelo.AuthResponse;
import com.cloud.backend.project.auth.Modelo.LoginRequest;
import com.cloud.backend.project.auth.Modelo.RegistroRequest;

public interface IAuthService {

    AuthResponse loginUsuario(LoginRequest loginRequest);
    Boolean registroUsuarioAtleta(RegistroRequest registroRequest);

}
