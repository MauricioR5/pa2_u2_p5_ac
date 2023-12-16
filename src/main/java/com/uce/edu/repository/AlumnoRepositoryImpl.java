package com.uce.edu.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AlumnoRepositoryImpl implements IAlumnoRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Alumno seleccionar(Integer id) {
		return this.entityManager.find(Alumno.class, id);
	}

	@Override
	public void insertar(Alumno alumno) {
		this.entityManager.persist(alumno);

	}

	@Override
	public void actualizar(Alumno alumno) {
		this.entityManager.merge(alumno);
	}

	@Override
	public void eliminar(Integer id) {
		Alumno alum = new Alumno();
		this.entityManager.remove(alum);
		}

}
