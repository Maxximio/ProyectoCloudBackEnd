package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Roles;

import java.util.List;

public interface IRolesRepository {

    public Boolean insertarRol(Roles rol);
    public Boolean actualizarRol(Roles rol);
    public Boolean eliminarRol(Integer id);
    public Roles buscarRol(Integer id);

    public List<Roles> buscarTodosRoles();

}
