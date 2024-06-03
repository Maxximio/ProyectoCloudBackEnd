package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Roles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class RolesRepositoryImpl implements IRolesRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Boolean insertarRol(Roles rol) {

        try {
            this.em.persist(rol);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean actualizarRol(Roles rol) {
        try {
            this.em.merge(rol);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean eliminarRol(Integer id) {
        try {
            this.em.remove(em.find(Roles.class, id));
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Roles buscarRol(Integer id) {

        return this.em.find(Roles.class, id);

    }
}
