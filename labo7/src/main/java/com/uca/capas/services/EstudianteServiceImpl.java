package com.uca.capas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	EstudianteRepo estudianteRepo;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.findAll();
	}

	@Override
	public Estudiante findOne(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.getOne(id);
	}

	@Override
	public void save(Estudiante e) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.save(e);
	}
	
	@Override
	public void save(Estudiante e, Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.save(e);
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.deleteById(id);
	}

	@Override
	public List<Estudiante> filtrarPorCadena(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.findByNombre(cadena);
	}



}
