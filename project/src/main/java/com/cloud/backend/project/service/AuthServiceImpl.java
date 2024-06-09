package com.cloud.backend.project.service;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.IUsuariosRepository;
import com.cloud.backend.project.repository.modelo.AuthResponse;
import com.cloud.backend.project.repository.modelo.ERol;
import com.cloud.backend.project.repository.modelo.LoginRequest;
import com.cloud.backend.project.repository.modelo.RegistroRequest;
import com.cloud.backend.project.repository.modelo.Roles;
import com.cloud.backend.project.repository.modelo.Usuarios;

@Service
public class AuthServiceImpl implements IAuthService{


    @Autowired
    private IUsuariosRepository usuariosRepository;

    @Autowired
    private IEncriptionService encriptionService;


    @Override
    public AuthResponse loginUsuario(LoginRequest loginRequest) {
        Usuarios usua = this.usuariosRepository.buscarPorEmail(loginRequest.getEmail());
        if(usua!=null && this.encriptionService.verificarEncriptedText(usua.getPassword(),loginRequest.getPassword())){
            return AuthResponse.builder()
                .id(usua.getId())
                .nombres(usua.getNombres())
                .apellidos(usua.getApellidos())
                .email(usua.getEmail())
                .estado(usua.getEstado())
                .estadoRegistro(usua.getEstadoRegistro())
                .fechaNacimiento(usua.getFechaNacimiento())
                .ciudad(usua.getApellidos())
                .contactoNombre(usua.getContactoNombre())
                .contactoTelefono(usua.getContactoTelefono())
                .direccion(usua.getDireccion())
                .roles(new ArrayList<Roles>(usua.getRoles()))
                .sexo(usua.getSexo())
                .telefono(usua.getTelefono())
                .build();
        }

        return null;
    }

    @Override
    public Boolean registroUsuarioAtleta(RegistroRequest registroRequest) {
        Boolean flag=false;
        if(registroRequest.getEmail()!=null && !registroRequest.getEmail().isEmpty() 
         && registroRequest.getPassword()!=null && !registroRequest.getPassword().isEmpty()){
               if(!this.usuariosRepository.existeUsuarioConEmail(registroRequest.getEmail())){
                try{
                    Usuarios usua = Usuarios.builder()
                        .nombres(registroRequest.getNombres())
                        .apellidos(registroRequest.getApellidos())
                        .email(registroRequest.getEmail())
                        .password(this.encriptionService.encriptPass(registroRequest.getPassword()))
                        .estado(registroRequest.getEstado())
                        .estadoRegistro(registroRequest.getEstadoRegistro())
                        .fechaNacimiento(registroRequest.getFechaNacimiento())
                        .ciudad(registroRequest.getApellidos())
                        .contactoNombre(registroRequest.getContactoNombre())
                        .contactoTelefono(registroRequest.getContactoTelefono())
                        .direccion(registroRequest.getDireccion())
                        .roles(Set.of(new Roles("Atleta",ERol.ATL)))
                        .sexo(registroRequest.getSexo())
                        .telefono(registroRequest.getTelefono())
                        .estado(true)
                        .estadoRegistro(false)
                    .build();
                    this.usuariosRepository.insertar(usua);
                    flag=true;
                }catch(Exception ex){
                   ex.printStackTrace();
                }
               }
        }
        return flag;
    }


    

}
