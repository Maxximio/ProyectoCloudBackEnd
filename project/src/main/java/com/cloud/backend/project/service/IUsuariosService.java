package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.Usuarios;
import com.cloud.backend.project.service.dto.UsuarioDTO;

import java.util.List;

public interface IUsuariosService {

    public Usuarios insertar(Usuarios usuario);
    public Usuarios buscarPorId(Integer id);
    public Boolean actualizar(Usuarios usuario);
    public Boolean eliminar(Integer id);

    public List<Usuarios> buscarTodosUsuarios();
    
    public List<Usuarios> buscarTodosUsuariosAdmin();
    
    public Boolean cambioEstado(Integer id) ;
    public Boolean cambioEstadoSocio(Integer id);
    public Boolean cambioEstado(Integer id,String nuevoEstado) ;

    public List<Usuarios> listarCiudadPorEstadoReg(String provincia,Boolean estadoRegistro);

    public List<UsuarioDTO> listarCiudadPorTipoDocumento(Boolean estado, String tipoDoc);

}
