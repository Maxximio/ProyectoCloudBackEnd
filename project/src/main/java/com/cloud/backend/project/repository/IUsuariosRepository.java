package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Usuarios;

public interface IUsuariosRepository {

    public Boolean insertar(Usuarios usuarios);
    public Usuarios buscarPorId(Integer id);
    public Boolean actualizar(Usuarios usuarios);
    public Boolean eliminar(Integer id);
}
