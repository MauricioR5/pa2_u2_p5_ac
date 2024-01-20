package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;

public interface IHotelRepository {
	
	public void insertar(Hotel hotel); 

	public Hotel seleccionarPorNombre(String nombre);
	
	public Hotel seleccionarPorNombreNative(String nombre);
	
	public List<Habitacion> seleccionarHabitacion(String nombre);
}
