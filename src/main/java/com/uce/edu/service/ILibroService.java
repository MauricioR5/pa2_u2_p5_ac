package com.uce.edu.service;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {

	public void agregar(Libro libro);
	
	public void agregar(Libro2 libro);
	
	public Libro buscarPorTitulo(String titulo);
}
