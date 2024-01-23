package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
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

		Ciudadano ciud = this.iCiudadanoService.buscarPorApellido("Cacuango");
		System.out.println(ciud);
		// Hibernate: select
		// c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from
		// ciudadano c1_0 where c1_0.ciud_nombre=?
		Ciudadano ciud1 = this.iCiudadanoService.buscarPorCriteria("Mauricio", "Cacuango", "173456789");
		System.out.println(ciud1);

		// Hibernate: select
		// c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from
		// ciudadano c1_0 where c1_0.ciud_apellido=?
		Ciudadano ciud2 = this.iCiudadanoService.buscarPorCriteria("Mauricio", "Cacuango", "0563456789");
		System.out.println(ciud2);

		// Hibernate: select
		// c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from
		// ciudadano c1_0 where c1_0.ciud_cedula=?
		Ciudadano ciud3 = this.iCiudadanoService.buscarPorCriteria("Mauricio", "Cacuango", "053456789");
		System.out.println(ciud3);
		
		Ciudadano ciud4 = this.iCiudadanoService.buscarPorCriteriaAndOr("Mauricio", "Cacuango", "173456789");
		System.out.println(ciud4);
	}
}
