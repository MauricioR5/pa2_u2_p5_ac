package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {

	public void agregar(Libro libro);
	
	public void agregar(Libro2 libro);
	
	public Libro buscarPorTitulo(String titulo);
	
	public List<Libro> buscarPorFecha(LocalDateTime fecha);
	
	public Libro buscarPorNombreNative(String nombre);
	
	public List<Libro> buscarPorFecha2(LocalDateTime fecha);
	
	public Libro buscarPorTituloNamed(String nombre);
	
	public List<Libro> buscarPorFechaNamed(LocalDateTime fecha);
	
	public Libro buscarPorCriteria(String titulo);
}

