package com.cloud.backend.project.repository;

import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.PreciosInscripciones;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PreciosInscripcionesRepositoryImpl implements IPreciosInscripcionesRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Boolean insertar(PreciosInscripciones preciosInscripciones) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.persist(preciosInscripciones);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Boolean actualizar(PreciosInscripciones preciosInscripciones) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.merge(preciosInscripciones);
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
	public PreciosInscripciones buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(PreciosInscripciones.class, id);
	}

}
