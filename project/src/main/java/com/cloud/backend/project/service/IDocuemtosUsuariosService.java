package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.modelo.DocumentosUsuarios;

public interface IDocuemtosUsuariosService {

    public Boolean insertarDocumentos(DocumentosUsuarios documentosUsuarios);
    public Boolean actualizarDocumentos(DocumentosUsuarios documentosUsuarios);
    public Boolean eliminarDocumentos(Integer id);
    public DocumentosUsuarios buscarDocumentos(Integer id);

}
