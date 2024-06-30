package com.cloud.backend.project.service;

import java.util.List;

import com.cloud.backend.project.repository.modelo.Usuarios;

public interface IUsuariosService {

    public Usuarios insertar(Usuarios usuario);
    public Usuarios buscarPorId(Integer id);
    public Boolean actualizar(Usuarios usuario);
    public Boolean eliminar(Integer id);

    public List<Usuarios> buscarTodosUsuarios();
    
    public Boolean cambioEstado(Integer id) ;
    public Boolean cambioEstado(Integer id,String nuevoEstado) ;

    public List<Usuarios> listarCiudadPorEstadoReg(String provincia,Boolean estadoRegistro);
    public List<Usuarios> listarCiudadPorTipoDocumento(String provincia,Boolean estado, String tipoDoc);

}
