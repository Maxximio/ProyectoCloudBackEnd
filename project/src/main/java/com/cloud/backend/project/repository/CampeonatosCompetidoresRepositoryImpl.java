package com.cloud.backend.project.repository;

import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.CampeonatosCompetidores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CampeonatosCompetidoresRepositoryImpl implements ICampeonatosCompetidoresRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Boolean insertar(CampeonatosCompetidores campeonatosCompetidores) {
		try {
			this.entityManager.persist(campeonatosCompetidores);;
			return true;
		} catch (Exception e) {
			return false;
		}		
	}

	@Override
	public CampeonatosCompetidores buscarPorId(Integer id) {
		return this.entityManager.find(CampeonatosCompetidores.class, id);
	}

	@Override
	public Boolean actualizar(CampeonatosCompetidores campeonatosCompetidores) {
		try {
			this.entityManager.merge(campeonatosCompetidores);
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
