package com.uce.edu.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AlumnoRepositoryImpl implements IAlumnoRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Alumno seleccionar(Integer id) {
		return this.entityManager.find(Alumno.class, id);
	}

	@Override
	public void insertar(Alumno alumno) {
		this.entityManager.persist(alumno);

	}

	@Override
	public void actualizar(Alumno alumno) {
		this.entityManager.merge(alumno);
	}

	@Override
	public void eliminar(Integer id) {
		Alumno alum = new Alumno();
		this.entityManager.remove(alum);
		}

	@Override
	public Alumno seleccionarPorNombre(String nombre) {
		TypedQuery<Alumno> myQuery = this.entityManager.createQuery("SELECT a FROM Alumno a WHERE a.nombre = : nombre",Alumno.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Alumno seleccionarPorCedula(String cedula) {
		TypedQuery<Alumno> myQuery = this.entityManager.createQuery("SELECT a FROM Alumno a WHERE a.cedula = : cedula",Alumno.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Alumno seleccionarPorApellido(String apellido) {
		TypedQuery<Alumno> myQuery = this.entityManager.createQuery("SELECT a FROM Alumno a WHERE a.apellido = : apellido",Alumno.class);
		myQuery.setParameter("apellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Alumno seleccionarPorNombreNative(String nombre) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM Alumno a WHERE a.alum_nombre =:nombre", Alumno.class);
		myQuery.setParameter("nombre", nombre);
		return (Alumno)myQuery.getSingleResult();
	}

	@Override
	public Alumno seleccionarPorCedulaNative(String cedula) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM Alumno l WHERE l.alum_cedula =:cedula", Alumno.class);
		myQuery.setParameter("cedula", cedula);
		return (Alumno)myQuery.getSingleResult();
	}

	@Override
	public Alumno seleccionarPorApellidoNative(String apellido) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM Alumno n WHERE n.alum_apellido =:apellido", Alumno.class);
		myQuery.setParameter("apellido", apellido);
		return (Alumno)myQuery.getSingleResult();
	}

}
