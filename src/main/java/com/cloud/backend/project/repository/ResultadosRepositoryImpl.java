package com.cloud.backend.project.repository;

import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.Resultados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ResultadosRepositoryImpl implements ResultadosRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Resultados buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Resultados.class, id);
	}

	@Override
	public void insertar(Resultados resultados) {
		// TODO Auto-generated method stub
		this.entityManager.persist(resultados);
	}

	@Override
	public void actualizar(Resultados resultados) {
		// TODO Auto-generated method stub
		this.entityManager.merge(resultados);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarId(id));
	}

}
