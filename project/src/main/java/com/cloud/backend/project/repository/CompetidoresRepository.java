package com.cloud.backend.project.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.Campeonatos;
import com.cloud.backend.project.repository.modelo.Competidores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CompetidoresRepository implements ICompetidoresRepository{
    
    @PersistenceContext
	private EntityManager entityManager;

    @Override
    public Boolean insertar(Competidores competidores) {
        try {
            this.entityManager.persist(competidores);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean actualizar(Competidores competidores) {
        try {
            this.entityManager.merge(competidores);
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
    public Competidores buscarPorId(Integer id) {
        return this.entityManager.find(Competidores.class, id);    
    }

	@Override
	public List<Competidores> listarCompetidores() {
        TypedQuery<Competidores> myQuery = this.entityManager.createQuery("SELECT c FROM Competidores c",Competidores.class);
        return myQuery.getResultList();
	}

}
