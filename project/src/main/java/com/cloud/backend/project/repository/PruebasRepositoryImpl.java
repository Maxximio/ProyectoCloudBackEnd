package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Campeonatos;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.Pruebas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class PruebasRepositoryImpl implements IPruebasRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Boolean insertar(Pruebas pruebas) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.persist(pruebas);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public Pruebas buscarPorId(Integer id) {
		// TODO Auto-generated method stub
			return this.entityManager.find(Pruebas.class, id);

	}

	@Override
	public Boolean actualizar(Pruebas pruebas) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.merge(pruebas);
			return true;
		}catch (Exception e) {
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
	public List<Pruebas> buscarTodas() {
		TypedQuery<Pruebas> myQ = this.entityManager.createQuery("SELECT p FROM Pruebas p",Pruebas.class);
		return myQ.getResultList();
	}

}
