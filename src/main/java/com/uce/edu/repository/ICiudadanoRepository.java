package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {

	public void insertar(Ciudadano ciudadano);
	
	public Ciudadano seleccionar(Integer id);
	
	public Empleado seleccionarPorCedula(String cedula);
	
	public Ciudadano seleccionarPorCedulaCiud(String cedula);
	
	//Criteria 
	
	public Ciudadano seleccionarPorApellido(String apellido);
	
	//Dinamico
	//Funcionalidad que cuando sea de Pichincha busque por nombre
		//De Cototpaxi por apellido
		//Si no es de ninguno, por cedula
		
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula);
	
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);

	
}
