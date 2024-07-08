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
    public Boolean actualizarCampeonatos(Campeonatos campeonatos) {
        try{
            Campeonatos camp = this.buscarPorId(campeonatos.getId());
            campeonatos.setId(camp.getId());
            this.em.merge(campeonatos);
            return true;
        }catch(Exception e){
            e.getMessage();
            return false;
        }
        
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
    public Boolean guarCampeonatos(Campeonatos campeonatos) {
        try {
            this.em.persist(campeonatos);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Campeonatos> listarCampeonatos() {
        TypedQuery<Campeonatos> myQ = this.em.createQuery("SELECT c FROM Campeonatos c",Campeonatos.class);
        return myQ.getResultList();
    }

    @Override
public List<Campeonatos> listarCampeonatosProvincia(String provincia) {
    TypedQuery<Campeonatos> myQ = this.em.createQuery("SELECT c FROM Campeonatos c WHERE c.sede = :provincia", Campeonatos.class);
    myQ.setParameter("provincia", provincia);
    return myQ.getResultList();
}


}
