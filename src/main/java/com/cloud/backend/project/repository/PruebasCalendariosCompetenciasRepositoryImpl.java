package com.cloud.backend.project.repository;

import org.springframework.stereotype.Repository;
import com.cloud.backend.project.repository.modelo.PruebasCalendariosCompetencias;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class PruebasCalendariosCompetenciasRepositoryImpl implements IPruebasCalendariosCompetenciasRepository {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Boolean insertar(PruebasCalendariosCompetencias pruebasCalendariosCompetencias) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.persist(pruebasCalendariosCompetencias);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}	
	}

	@Override
	public Boolean actualizar(PruebasCalendariosCompetencias pruebasCalendariosCompetencias) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.merge(pruebasCalendariosCompetencias);
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
			this.entityManager.remove(buscarPorId(id));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}		
	}

	@Override
	public PruebasCalendariosCompetencias buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(PruebasCalendariosCompetencias.class, id);
	}

}
