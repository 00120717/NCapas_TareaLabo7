package com.uca.capas.services;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;

public interface EstudianteService {
	public List<Estudiante> findAll() throws DataAccessException;
	public Estudiante findOne(Integer id) throws DataAccessException;
	public void save(Estudiante e) throws DataAccessException;
	public void save(Estudiante e,Integer id) throws DataAccessException;
	public void delete(Integer id) throws DataAccessException;
	public List<Estudiante> filtrarPorCadena(String cadena) throws DataAccessException;
}
