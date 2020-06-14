package com.uca.capas.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO{
	
	@PersistenceContext(unitName = "capas") 
	private	EntityManager entityManager;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(),Estudiante.class);	
		List<Estudiante> resulset = query.getResultList();
		return resulset;
	}

	@Override
	@Transactional
	public void insertar(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(estudiante);
	}

	@Override
	@Transactional
	public void delete(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Estudiante estudiante = entityManager.find(Estudiante.class, code);
		entityManager.remove(estudiante);
	}
	
	
}
