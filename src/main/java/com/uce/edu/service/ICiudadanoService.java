package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {

	public void agregar(Ciudadano ciudadano);
	
	public Ciudadano buscar(Integer id);
	
	public Empleado buscarPorCedula(String cedula);
	
	public Ciudadano buscarPorCedulaCiud(String cedula);
	//Criteria
	public Ciudadano buscarPorApellido(String apellido);
	
	public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula);
	
	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula);

}
