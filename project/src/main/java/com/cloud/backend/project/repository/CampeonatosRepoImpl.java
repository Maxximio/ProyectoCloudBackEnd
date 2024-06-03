package com.cloud.backend.project.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.Campeonatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CampeonatosRepoImpl implements ICampeonatosRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Campeonatos actualizarCampeonatos(Campeonatos campeonatos) {
        // TODO Auto-generated method stub
        Campeonatos camp = this.buscarPorId(campeonatos.getId());
        campeonatos.setId(camp.getId());
        return this.em.merge(campeonatos);
    }

    @Override
    public int borrarCampenatos(Integer id) {
        // TODO Auto-generated method stub
        int flag = 0;
        try{
            Campeonatos camp = this.em.find(Campeonatos.class, id);
            this.em.remove(camp);
            flag=1;
        }catch(NoResultException exception){
            throw new NoResultException("Campeonato no encontrado para el id ingresado");
        }
        return flag;
    }

    @Override
    public Campeonatos buscarPorId(Integer id) {
        Campeonatos camp ;
        try{
             camp = this.em.find(Campeonatos.class, id);
                       
        }catch(NoResultException exception){
            throw new NoResultException("Campeonato no encontrado para el id ingresado");
        }
        return camp;
    }

    @Override
    public Campeonatos guarCampeonatos(Campeonatos campeonatos) {
        // TODO Auto-generated method stub
        this.em.persist(campeonatos);
        return campeonatos;
    }

    @Override
    public List<Campeonatos> listarCampeonatos() {
        // TODO Auto-generated method stub
        TypedQuery<Campeonatos> myQ = this.em.createQuery("SELECT c FROM Campeonatos c",Campeonatos.class);
        return myQ.getResultList();
    }


}
