package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.IRolesRepository;
import com.cloud.backend.project.repository.modelo.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    IRolesRepository rolesRepository;

    @Override
    public Boolean insertarRol(Roles rol) {
        return this.rolesRepository.insertarRol(rol);
    }

    @Override
    public Boolean actualizarRol(Roles rol) {
        return this.rolesRepository.actualizarRol(rol);
    }

    @Override
    public Boolean eliminarRol(Integer id) {
        return this.rolesRepository.eliminarRol(id);
    }

    @Override
    public Roles buscar(Integer id) {
        return this.rolesRepository.buscarRol(id);
    }
}
