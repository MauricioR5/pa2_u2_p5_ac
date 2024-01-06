package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5AcApplication implements CommandLineRunner {
	
	@Autowired
	private ILibroService iLibroService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	Libro lib = new Libro();
	lib.setTitulo("Cien anios de soledad");
	lib.setFechaPublicacion(LocalDateTime.now());
	
	Autor autor = new Autor();
	autor.setNombre("Augusto Salazar");
	autor.setNacionalidad("Venezolano");
	
	Autor autor2 = new Autor();
	autor2.setNombre("Jhon Jairo");
	autor2.setNacionalidad("Ecuatoriano");
	
	Set<Autor> autores = new HashSet<Autor>();
	autores.add(autor);
	autores.add(autor2);
	
	lib.setAutores(autores);
	
	Set<Libro> libros = new HashSet<>();
	libros.add(lib);
	
	autor.setLibros(libros);
	autor2.setLibros(libros);
	
	this.iLibroService.agregar(lib);
	
	}

}
