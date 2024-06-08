package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

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
            Usuarios user = this.entityManager.find(Usuarios.class, id);
            this.entityManager.remove(user);
            return true;
        } catch (Exception e) {
            //System.out.println("Error, ->"+e);
            return false;
        }
    }

    @Override
	public List<Usuarios> buscarTodosUsuarios() {
        try {
            TypedQuery<Usuarios> myQuery = this.entityManager.createQuery("SELECT u FROM Usuarios u ",
                    Usuarios.class);
            return myQuery.getResultList();           
        } catch (Exception e) {
            return null;
        }

	}

	
	
	

}
