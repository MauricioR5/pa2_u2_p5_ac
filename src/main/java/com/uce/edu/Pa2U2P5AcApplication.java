package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;

@SpringBootApplication
public class Pa2U2P5AcApplication implements CommandLineRunner {


	
	@Autowired
	private ICiudadanoService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	
	Ciudadano ciud = this.iCiudadanoService.buscarPorCedulaCiud("123456789");
	
	System.out.println(ciud);
	
	Empleado empl = 	this.iCiudadanoService.buscarPorCedula("123456789");
	System.out.println(empl);
	
	}

}
