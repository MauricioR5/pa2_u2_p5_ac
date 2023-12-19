package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

@SpringBootApplication
public class Pa2U2P5AcApplication implements CommandLineRunner {
	
	@Autowired
	private IEmpleadoService iEmpleadoService;
	
	@Autowired
	private ICiudadanoService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Ciudadano ciud = new Ciudadano();
		ciud.setNombre("Mauricio");
		ciud.setApellido("Cacuango");
		
		Empleado empl = new Empleado();
		empl.setSalario(new BigDecimal(460));
		empl.setFechaIngreso(LocalDateTime.now());
		empl.setCiudadano(ciud);
		
		empl.setCiudadano(this.iCiudadanoService.buscar(1));
		this.iEmpleadoService.agregar(empl);
		//this.iCiudadanoService.agregar(ciud);
		
		//this.iCiudadanoService.buscar(1);
		
	}

}
