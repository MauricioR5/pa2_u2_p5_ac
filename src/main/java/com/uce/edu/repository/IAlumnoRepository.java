package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoRepository {

	public Alumno seleccionar(Integer id);

	public void insertar(Alumno alumno);

	public void actualizar(Alumno alumno);

	public void eliminar(Integer id);

	public Alumno seleccionarPorNombre(String nombre);

	public Alumno seleccionarPorCedula(String cedula);

	public Alumno seleccionarPorApellido(String apellido);

	public Alumno seleccionarPorNombreNative(String nombre);

	public Alumno seleccionarPorCedulaNative(String cedula);

	public Alumno seleccionarPorApellidoNative(String apellido);
}
