package com.cloud.backend.project.repository;

import java.util.List;

import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;
import com.cloud.backend.project.repository.modelo.Usuarios;

public interface IUsuariosRepository {

    public Usuarios insertar(Usuarios usuarios);
    public Usuarios buscarPorId(Integer id);
    public Boolean actualizar(Usuarios usuarios);
    public Boolean eliminar(Integer id);
    public List<Usuarios> buscarTodosUsuarios();

    public Usuarios buscarPorEmail(String email);

    public boolean existeUsuarioConEmail(String email) ;

    public List<Usuarios> listarCiudadPorEstadoReg(String provincia,Boolean estadoRegistro);
    public List<Usuarios> listarCiudadPorTipoDocumento(String provincia,Boolean estado, String tipoDoc);


}
