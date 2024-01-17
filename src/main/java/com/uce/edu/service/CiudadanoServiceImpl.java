package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepository iCiudadanoRepository;
	@Override
	public void agregar(Ciudadano ciudadano) {
		this.iCiudadanoRepository.insertar(ciudadano);
	}
	@Override
	public Ciudadano buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionar(id);
	}
	@Override
	public Empleado buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCedula(cedula);
	}
	@Override
	public Ciudadano buscarPorCedulaCiud(String cedula) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionarPorCedulaCiud(cedula);
	}

}
