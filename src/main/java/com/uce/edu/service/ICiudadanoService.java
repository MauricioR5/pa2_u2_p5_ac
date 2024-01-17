package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {

	public void agregar(Ciudadano ciudadano);
	
	public Ciudadano buscar(Integer id);
	
	public Empleado buscarPorCedula(String cedula);
	
	public Ciudadano buscarPorCedulaCiud(String cedula);
}
