package com.cloud.backend.project.service;

import com.cloud.backend.project.repository.IUsuariosRepository;
import com.cloud.backend.project.repository.modelo.Usuarios;
import com.cloud.backend.project.service.dto.UsuarioDTO;
import com.cloud.backend.project.service.dto.UsuarioDocumentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class UsuariosServiceImpl implements IUsuariosService{

    @Autowired
    IUsuariosRepository usuariosRepository;

    @Override
    public Boolean actualizar(Usuarios usuario) {
        return this.usuariosRepository.actualizar(usuario);
    }

    @Override
    public Usuarios buscarPorId(Integer id) {
        return this.usuariosRepository.buscarPorId(id);
    }

    @Override
    public Boolean eliminar(Integer id) {
        return this.usuariosRepository.eliminar(id);
    }

    @Override
    public Usuarios insertar(Usuarios usuario) {
        return this.usuariosRepository.insertar(usuario);
    }

    @Override
    public List<Usuarios> buscarTodosUsuarios() {
        return this.usuariosRepository.buscarTodosUsuarios();
    }

    @Override
    public List<Usuarios> buscarTodosUsuariosAdmin() {
        return this.usuariosRepository.buscarTodosUsuariosAdmin();
    }

	@Override
	public Boolean cambioEstado(Integer id) {
		Usuarios usuario= this.usuariosRepository.buscarPorId(id);
		
		usuario.setEstadoRegistro(!usuario.getEstadoRegistro());
		
		return this.usuariosRepository.actualizar(usuario);
				
	}

    public Boolean cambioEstadoSocio(Integer id) {
        Usuarios usuario= this.usuariosRepository.buscarPorId(id);

        usuario.setEstado(!usuario.getEstado());
        // Agregar un año a la fecha actual
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaEnUnAno = fechaActual.plus(1, ChronoUnit.YEARS);

        // Convertir LocalDate a Date
        Date fechaSuscripcion = java.sql.Date.valueOf(fechaEnUnAno);

        usuario.setFechaSuscripción(fechaSuscripcion);

        return this.usuariosRepository.actualizar(usuario);

    }

    @Override
    public Boolean cambioEstado(Integer id, String nuevoEstado) {
        Usuarios usuario= this.usuariosRepository.buscarPorId(id);
        System.out.println(Boolean.parseBoolean(nuevoEstado));
        usuario.setEstadoRegistro(Boolean.parseBoolean(nuevoEstado));
        System.out.println(usuario);
        return this.usuariosRepository.actualizar(usuario);
    }

    @Override
    public List<Usuarios> listarCiudadPorEstadoReg(String provincia, Boolean estadoRegistro) {
        return this.usuariosRepository.listarCiudadPorEstadoReg(provincia, estadoRegistro);
    }


    @Override
    public List<UsuarioDocumentoDTO> listarCiudadPorTipoDocumento(Boolean estado, String tipoDoc, String provincia) {
        return this.usuariosRepository.listarCiudadPorTipoDocumento(estado, tipoDoc, provincia);
    }


}
