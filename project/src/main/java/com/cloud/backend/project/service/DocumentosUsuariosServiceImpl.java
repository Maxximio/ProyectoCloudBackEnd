package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.IDocumentosUsuariosRepo;
import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentosUsuariosServiceImpl implements IDocumetosUsuariosService{

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

    @Override
    public List<DocumentosUsuarios> buscarDocumentosDeUsuarioDadoId(Integer id) {
        return this.documentosUsuariosRepo.buscarDocumentosDeUsuarioDadoId(id);
    }


}
