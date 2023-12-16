package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAlumnoRepository;
import com.uce.edu.repository.modelo.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
	
	@Autowired
	private IAlumnoRepository iAlumnoRepository;
	
	@Override
	public Alumno buscar(Integer id) {
		return this.iAlumnoRepository.seleccionar(id);
	}

	@Override
	public void agregar(Alumno alumno) {

		this.iAlumnoRepository.insertar(alumno);
	}

	@Override
	public void actualizar(Alumno alumno) {

		this.iAlumnoRepository.actualizar(alumno);
	}

	@Override
	public void eliminar(Integer id) {

		this.iAlumnoRepository.eliminar(id);
	}

}
