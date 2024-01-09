package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroRepository {

	public void insertar(Libro libro);
	
	public void insertar(Libro2 libro2);
	
	public Libro seleccionarPorTitulo(String nombre);
	
}
