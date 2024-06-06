package com.cloud.backend.project.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DocumentosUsuariosRepositoryImpl implements IDocumentosUsuariosRepo{

    @PersistenceContext
    private EntityManager em;


    @Override
    public Boolean insertarDocumentos(DocumentosUsuarios documentosUsuarios) {
        try{
            this.em.persist(documentosUsuarios);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean actualizarDocumentos(DocumentosUsuarios documentosUsuarios) {
        try {
            this.em.merge(documentosUsuarios);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean eliminarDocumentos(Integer id) {
        try {
            this.em.remove(em.find(DocumentosUsuarios.class, id));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public DocumentosUsuarios buscarDocumentos(Integer id) {
        return this.em.find(DocumentosUsuarios.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DocumentosUsuarios> buscarDocumentosDeUsuarioDadoId(Integer id) {
        try {
            String sql = "SELECT d FROM DocumentosUsuarios d WHERE d.usuarios.id = :id";
            Query myQuery = this.em.createQuery(sql);
            myQuery.setParameter("id", id);
		    return myQuery.getResultList(); 
            
        } catch (Exception e) {
            //System.out.println("ERRORR- >>>"+e);
            return null;
        }
    }


}
