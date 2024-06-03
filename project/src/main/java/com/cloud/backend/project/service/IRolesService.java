package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.Roles;

public interface IRolesService {

    public Boolean insertarRol(Roles rol);
    public Boolean actualizarRol(Roles rol);
    public Boolean eliminarRol(Integer id);
    public Roles buscar(Integer id);

}
