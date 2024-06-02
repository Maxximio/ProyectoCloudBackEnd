package com.cloud.backend.project.repository;

import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.CampeonatosPruebas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CampeonatosPruebasImpl implements ICampeonatosPruebas {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Boolean insertar(CampeonatosPruebas campeonatosPruebas) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.persist(campeonatosPruebas);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}	}

	@Override
	public Boolean actualizar(CampeonatosPruebas campeonatosPruebas) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.merge(campeonatosPruebas);
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
	public CampeonatosPruebas buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CampeonatosPruebas.class, id);
	}

}
