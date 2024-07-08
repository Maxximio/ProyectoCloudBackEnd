package com.cloud.backend.project.repository;

import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.CategoriasPruebas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CategoriasPruebasRepositoryImpl implements CategoriasPruebasRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CategoriasPruebas buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CategoriasPruebas.class, id);
	}

	@Override
	public void insertar(CategoriasPruebas categoriasPruebas) {
		// TODO Auto-generated method stub
		this.entityManager.persist(categoriasPruebas);
	}

	@Override
	public void actualizar(CategoriasPruebas categoriasPruebas) {
		// TODO Auto-generated method stub
		this.entityManager.merge(categoriasPruebas);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarId(id));
	}

}
