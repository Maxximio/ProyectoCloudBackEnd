package com.cloud.backend.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.IAsociacionesDeportivasRepository;
import com.cloud.backend.project.repository.modelo.AsociacionesDeportivas;
@Service
public class AsociacionesDeportivasServiceImpl implements IAsociacionesDeportivasService {
	@Autowired
	private IAsociacionesDeportivasRepository asociacionesDeportivasRepository;

	@Override
	public Boolean insertar(AsociacionesDeportivas asociacionesDeportivas) {
		// TODO Auto-generated method stub
		return asociacionesDeportivasRepository.insertar(asociacionesDeportivas);
	}

	@Override
	public Boolean actualizar(AsociacionesDeportivas asociaDeportivas) {
		// TODO Auto-generated method stub
		AsociacionesDeportivas deportivas=
				this.asociacionesDeportivasRepository
				.buscarPorId(asociaDeportivas.getId());
		deportivas.setNombre(asociaDeportivas.getNombre());
		return asociacionesDeportivasRepository
				.actualizar(deportivas);
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return asociacionesDeportivasRepository.eliminar(id);
	}

	@Override
	public AsociacionesDeportivas buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return asociacionesDeportivasRepository.buscarPorId(id);
	}

}
