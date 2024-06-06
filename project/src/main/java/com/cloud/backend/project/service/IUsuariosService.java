package com.cloud.backend.project.service;

import java.util.List;

import com.cloud.backend.project.repository.modelo.Usuarios;

public interface IUsuariosService {

    public Boolean insertar(Usuarios usuario);
    public Usuarios buscarPorId(Integer id);
    public Boolean actualizar(Usuarios usuario);
    public Boolean eliminar(Integer id);

    public List<Usuarios> buscarTodosUsuarios();
}
