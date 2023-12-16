package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5AcApplication implements CommandLineRunner {
	
	@Autowired
	private IEstudianteService iEstudianteService;
	
	@Autowired
	private IAlumnoService iAlumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Estudiante
		//Agregar
		/*Estudiante estu = new Estudiante();
		estu.setNombre("Mauricio");
		estu.setApellido("Cacuango");
		estu.setCedula("1232323");
		estu.setFechaNacimiento(LocalDateTime.now());
		
		//this.iEstudianteService.agregar(estu);
		
		//buscar
		
		Estudiante estu1 = this.iEstudianteService.buscar(1);	
		System.out.println(estu1);
		
		//actualizar
		
		estu1.setNombre("Alexander");
		this.iEstudianteService.actualizar(estu1);
		
		//eliminar
		
		//this.iEstudianteService.eliminar(2);
		*/
		//Alumno
		//agregar
		Alumno alum = new Alumno();
		alum.setNombre("Emiliano");
		
		//this.iAlumnoService.agregar(alum);
		
		//buscar
		Alumno alum1 = this.iAlumnoService.buscar(1);
		System.out.println(alum1);
		
		//actualizar
		alum1.setNombre("Augusto");
		this.iAlumnoService.actualizar(alum1);
		
		//borrar
		this.iAlumnoService.eliminar(1);
		
		
	}

}
