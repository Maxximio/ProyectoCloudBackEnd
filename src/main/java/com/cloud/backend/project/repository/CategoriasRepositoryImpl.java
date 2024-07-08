package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Competidores;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.Categorias;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoriasRepositoryImpl implements ICategoriasRepository{

	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public Boolean insertar(Categorias categorias) {
		try {
			this.entityManager.persist(categorias);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	@Override
	public Categorias buscarPorId(Integer id) {
		return this.entityManager.find(Categorias.class, id);
	}
	

	@Override
	public Boolean actualizar(Categorias categorias) {
		try {
			this.entityManager.merge(categorias);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			this.entityManager.remove(this.buscarPorId(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Categorias> listarCategorias() {
		TypedQuery<Categorias> myQuery = this.entityManager.createQuery("SELECT c FROM Categorias c",Categorias.class);
		return myQuery.getResultList();
	}
	

}
