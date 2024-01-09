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

		Libro2 lib = new Libro2();
		lib.setTitulo("Cien anios de soledad 2");
		lib.setFechaPublicacion(LocalDateTime.now());

		Autor2 autor = new Autor2();
		autor.setNombre("Augusto Salazar 2");
		autor.setNacionalidad("Venezolano 2");

		Autor2 autor2 = new Autor2();
		autor2.setNombre("Jhon Jairo 2");
		autor2.setNacionalidad("Ecuatoriano 2");

		Set<Autor2> autores = new HashSet<Autor2>();
		autores.add(autor);
		autores.add(autor2);

		// Primer registro
		AutorLibro autorLibro1 = new AutorLibro();
		autorLibro1.setLibro2(lib);
		autorLibro1.setAutor2(autor);
		autorLibro1.setFecha(LocalDateTime.now());
		// segundo registro
		AutorLibro autorLibro2 = new AutorLibro();
		autorLibro2.setLibro2(lib);
		autorLibro2.setAutor2(autor2);
		autorLibro2.setFecha(LocalDateTime.now());

		List<AutorLibro> lista = new ArrayList<>();
		lista.add(autorLibro1);
		lista.add(autorLibro2);

		lib.setAutoresLibros(lista);

		//this.iLibroService.agregar(lib);
		
		Libro libroFinal = this.iLibroService.buscarPorTitulo("Cien anios de soledad");
		System.out.println(libroFinal);
	}

}
