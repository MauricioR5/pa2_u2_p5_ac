package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5AcApplication implements CommandLineRunner {

	@Autowired
	private IAlumnoService iAlumnoService;

	@Autowired
	private ILibroService iLibroService;

	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Alumno alum = this.iAlumnoService.buscarPorCriteria("Jairo", "Perez", "17171717");
		System.out.println(alum);

		Alumno alum2 = this.iAlumnoService.buscarPorCriteria("Pepe", "Gonzales", "12345678");
		System.out.println(alum2);

		Libro lb = this.iLibroService.buscarPorCriteria("REDES");
		System.out.println(lb);

		Alumno alum3 = this.iAlumnoService.buscarPorCedulaCri("17171717");
		System.out.println(alum3);

		Hotel hote = this.iHotelService.buscarPorCriteria("Marriot");
		System.out.println(hote);
	}
}
