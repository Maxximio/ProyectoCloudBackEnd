package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.IDocumentosUsuariosRepo;
import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentosUsuariosServiceImpl implements IDocuemtosUsuariosService{

    @Autowired
    IDocumentosUsuariosRepo documentosUsuariosRepo;

    @Override
    public Boolean insertarDocumentos(DocumentosUsuarios documentosUsuarios) {
        return this.documentosUsuariosRepo.insertarDocumentos(documentosUsuarios);
    }

    @Override
    public Boolean actualizarDocumentos(DocumentosUsuarios documentosUsuarios) {
        return this.documentosUsuariosRepo.actualizarDocumentos(documentosUsuarios);
    }

    @Override
    public Boolean eliminarDocumentos(Integer id) {
        return this.documentosUsuariosRepo.eliminarDocumentos(id);
    }

    @Override
    public DocumentosUsuarios buscarDocumentos(Integer id) {
        return this.documentosUsuariosRepo.buscarDocumentos(id);
    }
}
