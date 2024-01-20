package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;

public interface IHotelService {

	public void guardar(Hotel hotel);
	
	public Hotel buscarPorNombre(String nombre);
	
	public Hotel buscarPorNombreNative(String numero);
	
	public List<Habitacion> buscarHabitacion(String nombre);
}
