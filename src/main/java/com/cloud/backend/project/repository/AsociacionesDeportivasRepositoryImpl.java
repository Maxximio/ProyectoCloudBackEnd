package com.cloud.backend.project.repository;

import org.springframework.stereotype.Repository;
import com.cloud.backend.project.repository.modelo.AsociacionesDeportivas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class AsociacionesDeportivasRepositoryImpl implements IAsociacionesDeportivasRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Boolean insertar(AsociacionesDeportivas asociacionesDeportivas) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.persist(asociacionesDeportivas);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Boolean actualizar(AsociacionesDeportivas asocicacionesDeportivas) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.merge(asocicacionesDeportivas);
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
	public AsociacionesDeportivas buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(AsociacionesDeportivas.class, id);
	}

}
