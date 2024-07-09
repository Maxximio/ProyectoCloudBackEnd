package com.cloud.backend.project.service;

import com.cloud.backend.project.service.dto.CompetidoresDTO;
import com.cloud.backend.project.service.dto.CompetidoresPruebasDTO;
import com.cloud.backend.project.service.dto.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.backend.project.repository.ICompetidoresPruebasRepository;
import com.cloud.backend.project.repository.modelo.CompetidoresPruebas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetidoresPruebasServiceImpl implements ICompetidoresPruebasService{
	
	@Autowired
	private ICompetidoresPruebasRepository competidoresPruebasRepository;
	@Autowired
	private Converter converter;

	@Override
	public Boolean insertar(CompetidoresPruebas competidoresPruebas) {
		// TODO Auto-generated method stub
		return this.competidoresPruebasRepository.insertar(competidoresPruebas);
	}

	@Override
	public CompetidoresPruebas buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.competidoresPruebasRepository.buscarPorId(id);
	}

	@Override
	public Boolean actualizar(CompetidoresPruebas competidoresPruebas) {
		// TODO Auto-generated method stub
		return this.competidoresPruebasRepository.actualizar(competidoresPruebas);
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return this.competidoresPruebasRepository.eliminar(id);
	}

	@Override
	public List<CompetidoresPruebas> obtenerTodos() {
		return this.competidoresPruebasRepository.obtenerTodos();
	}

	@Override
	public HashMap<String,List<CompetidoresDTO>> obtenerTodosDTO() {
		List<CompetidoresPruebas> dtos=this.obtenerTodos();
		List<CompetidoresPruebasDTO> res=dtos.stream().map(dto-> converter.covertToDto(dto)).collect(Collectors.toList());
		HashMap<String,List<CompetidoresDTO>> map=new HashMap<>();
		res.forEach(x->{

			if(map.containsKey(x.getPrueba().getNombre())){
				map.get(x.getPrueba().getNombre()).add(x.getCompetidor());
			}else{
				List<CompetidoresDTO> list=new ArrayList<>();
				list.add(x.getCompetidor());
				map.put(x.getPrueba().getNombre(),list);
			}
		});
		return map;
	}


}
