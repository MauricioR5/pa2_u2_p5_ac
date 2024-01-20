package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHotelRepository;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository iHotelRepository;
	@Override
	
	public void guardar(Hotel hotel) {
		this.iHotelRepository.insertar(hotel);
	}
	@Override
	public Hotel buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarPorNombre(nombre);
	}
	@Override
	public Hotel buscarPorNombreNative(String nombre) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarPorNombreNative(nombre);
	}
	@Override
	public List<Habitacion> buscarHabitacion(String nombre) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarHabitacion(nombre);
	}

}
