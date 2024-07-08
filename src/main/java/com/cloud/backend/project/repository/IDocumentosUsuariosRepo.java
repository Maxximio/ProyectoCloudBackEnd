package com.cloud.backend.project.repository;

import java.util.List;

import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;

public interface IDocumentosUsuariosRepo {

    public Boolean insertarDocumentos(DocumentosUsuarios documentosUsuarios);
    public Boolean actualizarDocumentos(DocumentosUsuarios documentosUsuarios);
    public Boolean eliminarDocumentos(Integer id);
    public DocumentosUsuarios buscarDocumentos(Integer id);

    public List<DocumentosUsuarios> buscarDocumentosDeUsuarioDadoId(Integer id);

}
