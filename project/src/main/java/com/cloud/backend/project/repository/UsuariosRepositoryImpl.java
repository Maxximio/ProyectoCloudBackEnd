package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsuariosRepositoryImpl implements IUsuariosRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean insertar(Usuarios usuarios) {
        try {
            this.entityManager.persist(usuarios);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Usuarios buscarPorId(Integer id) {
        return this.entityManager.find(Usuarios.class, id);
    }

    @Override
    public Boolean actualizar(Usuarios usuarios) {
        try {
            this.entityManager.merge(usuarios);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean eliminar(Integer id) {
        try {
            this.entityManager.remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}