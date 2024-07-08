package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Roles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Roles> buscarTodosRoles() {
        try {
            TypedQuery<Roles> myQuery = this.em.createQuery("SELECT r FROM Roles r ",
                    Roles.class);
            return myQuery.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
