package com.cloud.backend.project.service;

import java.util.List;

import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;

public interface IDocumetosUsuariosService {

    public Boolean insertarDocumentos(DocumentosUsuarios documentosUsuarios);
    public Boolean actualizarDocumentos(DocumentosUsuarios documentosUsuarios);
    public Boolean eliminarDocumentos(Integer id);
    public DocumentosUsuarios buscarDocumentos(Integer id);

    public List<DocumentosUsuarios> buscarDocumentosDeUsuarioDadoId(Integer id);

}
