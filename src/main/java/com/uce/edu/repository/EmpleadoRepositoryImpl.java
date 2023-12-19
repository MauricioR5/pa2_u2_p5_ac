package com.uce.edu.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {

	@Autowired
	private EntityManager entityManager;
	@Override
	public void insertar(Empleado empleado) {
		this.entityManager.persist(empleado);
	}

}
