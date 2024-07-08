package com.cloud.backend.project.repository;

import org.springframework.stereotype.Repository;
import com.cloud.backend.project.repository.modelo.AsociacionesDeportivasCampeonatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AsociacionesDeportivasCampeonatosRepository implements IAsociacionesDeportivasCampeonatosRepository{

    @PersistenceContext
	private EntityManager entityManager;

    @Override
    public Boolean insertar(AsociacionesDeportivasCampeonatos asociacionesDeportivasCampeonatos) {
        try {
            this.entityManager.persist(asociacionesDeportivasCampeonatos);
			return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean actualizar(AsociacionesDeportivasCampeonatos asociacionesDeportivasCampeonatos) {
        try {
            this.entityManager.merge(asociacionesDeportivasCampeonatos);
			return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean eliminar(Integer id) {
        try {
            this.entityManager.remove(buscarPorId(id));
			return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public AsociacionesDeportivasCampeonatos buscarPorId(Integer id) {
         return this.entityManager.find(AsociacionesDeportivasCampeonatos.class, id);    
    }

}