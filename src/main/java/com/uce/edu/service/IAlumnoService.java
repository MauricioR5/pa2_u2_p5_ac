package com.uce.edu.service;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoService {

	public Alumno buscar(Integer id);

	public void agregar(Alumno alumno);

	public void actualizar(Alumno alumno);

	public void eliminar(Integer id);

	public Alumno buscarPorNombre(String nombre);

	public Alumno buscarPorCedula(String cedula);

	public Alumno buscarPorApellido(String apellido);

	public Alumno buscarPorNombreNative(String nombre);

	public Alumno buscarPorCedulaNative(String cedula);

	public Alumno buscarPorApellidoNative(String apellido);

	public Alumno buscarPorCriteria(String nombre, String apellido, String cedula);

	public Alumno buscarPorCedulaCri(String cedula);
}
