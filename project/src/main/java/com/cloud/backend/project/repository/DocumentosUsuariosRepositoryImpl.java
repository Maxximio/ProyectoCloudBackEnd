package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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
}
