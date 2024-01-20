package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5AcApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;

	@Autowired
	private IHotelService iHotelService;

	@Autowired
	private IAlumnoService iAlumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Ejemplos Typed

		Hotel hote1 = this.iHotelService.buscarPorNombre("Marriot");
		System.out.println(hote1);

		List<Habitacion> hab = this.iHotelService.buscarHabitacion("Marriot");
		System.out.println(hab);

		Alumno alum1 = this.iAlumnoService.buscarPorNombre("Jairo");
		System.out.println(alum1);

		Alumno alum3 = this.iAlumnoService.buscarPorCedula("17171717");
		System.out.println(alum3);

		Alumno alum5 = this.iAlumnoService.buscarPorApellido("Gonzales");
		System.out.println(alum5);

		// Ejemplos Native

		Alumno alum6 = this.iAlumnoService.buscarPorApellidoNative("Perez");
		System.out.println(alum6);

		Alumno alum4 = this.iAlumnoService.buscarPorCedulaNative("17171717");
		System.out.println(alum4);

		Hotel hote2 = this.iHotelService.buscarPorNombreNative("Marriot");
		System.out.println(hote2);

		Libro lb = this.iLibroService.buscarPorNombreNative("REDES");
		System.out.println(lb);

		Alumno alum2 = this.iAlumnoService.buscarPorNombreNative("Pepe");
		System.out.println(alum2);

	}
}
