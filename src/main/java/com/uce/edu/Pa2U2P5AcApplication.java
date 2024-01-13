package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
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
		System.out.println("Query");
				
		List<Libro>lista = this.iLibroService.buscarPorFecha(LocalDateTime.of(2022,1,1,5,20));
		for(Libro libro : lista) {
		System.out.println(libro);
		}
		
		
		System.out.println("TypedQuery");
		Libro lib1 = this.iLibroService.buscarPorNombre("JAVA");
		System.out.println(lib1);
		
		List<Libro> lista2 = this.iLibroService.buscarPorFecha2(LocalDateTime.of(2022,1,1,1,20));
		for(Libro libro : lista2) {
			System.out.println(libro);
			}
		
		System.out.println("NamedQuery");
		
		Libro lib2 = this.iLibroService.buscarPorTituloNamed("PYTHON");
		System.out.println(lib2);
		
		List<Libro> lista3 = this.iLibroService.buscarPorFechaNamed(LocalDateTime.of(2022,1,1,1,20));
		for(Libro libro : lista3) {
			System.out.println(libro);
	}
	}

}
