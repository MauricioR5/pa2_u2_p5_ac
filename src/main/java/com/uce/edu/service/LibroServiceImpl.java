package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ILibroRepository;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private ILibroRepository iLibroRepository;

	@Override
	public void agregar(Libro libro) {

		this.iLibroRepository.insertar(libro);
	}

	@Override
	public void agregar(Libro2 libro2) {
		this.iLibroRepository.insertar(libro2);
	}

	@Override
	public Libro buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorTitulo(titulo);
	}

	@Override
	public List<Libro> buscarPorFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorFechaPublicacion(fecha);
	}

	@Override
	public Libro buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorNombre(nombre);
	}

	@Override
	public List<Libro> buscarPorFecha2(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorFecha(fecha);
	}

	@Override
	public Libro buscarPorTituloNamed(String nombre) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorTituloNamed(nombre);
	}

	@Override
	public List<Libro> buscarPorFechaNamed(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorFechaNamed(fecha);
	}



}
