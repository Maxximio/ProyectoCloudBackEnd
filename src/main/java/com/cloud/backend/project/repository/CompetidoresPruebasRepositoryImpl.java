package com.cloud.backend.project.repository;

import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.CompetidoresPruebas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class CompetidoresPruebasRepositoryImpl implements ICompetidoresPruebasRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Boolean insertar(CompetidoresPruebas competidoresPruebas) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.persist(competidoresPruebas);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public CompetidoresPruebas buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CompetidoresPruebas.class, id);
	}

	@Override
	public Boolean actualizar(CompetidoresPruebas competidoresPruebas) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.merge(competidoresPruebas);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.remove(this.buscarPorId(id));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<CompetidoresPruebas> obtenerTodos() {
		// TODO Auto-generated method stub
			TypedQuery<CompetidoresPruebas> myQuery = this.entityManager.createQuery("SELECT c FROM CompetidoresPruebas c",CompetidoresPruebas.class);
			return myQuery.getResultList();
	}

}
