package com.cloud.backend.project.repository;

import com.cloud.backend.project.repository.modelo.Usuarios;
import com.cloud.backend.project.service.dto.UsuarioDTO;
import com.cloud.backend.project.service.dto.UsuarioDocumentoDTO;

import java.util.List;

public interface IUsuariosRepository {

    public Usuarios insertar(Usuarios usuarios);
    public Usuarios buscarPorId(Integer id);
    public Boolean actualizar(Usuarios usuarios);
    public Boolean eliminar(Integer id);
    public List<Usuarios> buscarTodosUsuarios();

    public List<Usuarios> buscarTodosUsuariosAdmin();

    public Usuarios buscarPorEmail(String email);

    public boolean existeUsuarioConEmail(String email) ;

    public List<Usuarios> listarCiudadPorEstadoReg(String provincia,Boolean estadoRegistro);

    public List<UsuarioDocumentoDTO> listarCiudadPorTipoDocumento(Boolean estado, String tipoDoc, String provincia);

}
