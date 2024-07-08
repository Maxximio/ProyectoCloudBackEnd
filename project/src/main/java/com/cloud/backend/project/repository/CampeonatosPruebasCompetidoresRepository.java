package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebasCompetidores;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CampeonatosPruebasCompetidoresRepository implements ICampeonatosPruebasCompetidoresRepository{

    @PersistenceContext
	private EntityManager entityManager;

    @Override
    public Boolean insertar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores) {
        try {
            this.entityManager.persist(campeonatosPruebasCompetidores);
			return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean actualizar(CampeonatosPruebasCompetidores campeonatosPruebasCompetidores) {
        try {
            this.entityManager.merge(campeonatosPruebasCompetidores);
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
    public CampeonatosPruebasCompetidores buscarPorId(Integer id) {
         return this.entityManager.find(CampeonatosPruebasCompetidores.class, id);
    }

    @Override
    public List<CampeonatosPruebasCompetidores> buscarTodos() {
        TypedQuery<CampeonatosPruebasCompetidores> myQuery=this.entityManager.createQuery("SELECT cpc from CampeonatosPruebasCompetidores cpc", CampeonatosPruebasCompetidores.class);

        return myQuery.getResultList();
    }

}