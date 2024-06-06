package com.cloud.backend.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.IUsuariosRepository;
import com.cloud.backend.project.repository.modelo.Usuarios;

@Service
public class UsuariosServiceImpl implements IUsuariosService{

    @Autowired
    IUsuariosRepository usuariosRepository;

    @Override
    public Boolean actualizar(Usuarios usuario) {
        return this.usuariosRepository.actualizar(usuario);
    }

    @Override
    public Usuarios buscarPorId(Integer id) {
        return this.usuariosRepository.buscarPorId(id);
    }

    @Override
    public Boolean eliminar(Integer id) {
        return this.usuariosRepository.eliminar(id);
    }

    @Override
    public Boolean insertar(Usuarios usuario) {
        return this.usuariosRepository.insertar(usuario);
    }

    @Override
    public List<Usuarios> buscarTodosUsuarios() {
        return this.usuariosRepository.buscarTodosUsuarios();
    }
    
}
