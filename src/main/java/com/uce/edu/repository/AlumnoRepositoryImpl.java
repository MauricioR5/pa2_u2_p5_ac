package com.uce.edu.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	@Override
	public Alumno seleccionarPorCriteria(String nombre, String apellido, String cedula) {
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Alumno> myCriteriaQuery = myCriteriaBuilder.createQuery(Alumno.class);
		Root<Alumno> myFrom = myCriteriaQuery.from(Alumno.class);
		
		Predicate condicionGenerica = null;
		if(cedula.startsWith("17")){
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		}else if(cedula.startsWith("12")){
			 condicionGenerica = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);

		}else {
			 condicionGenerica = myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);

		}
		myCriteriaQuery.select(myFrom).where(condicionGenerica);
		TypedQuery<Alumno> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Alumno seleccionarPorCedulaCri(String cedula) {
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Alumno> myCriteriaQuery = myCriteriaBuilder.createQuery(Alumno.class);

		Root<Alumno> myFrom = myCriteriaQuery.from(Alumno.class);

		Predicate condicionCedula = myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);
		myCriteriaQuery.select(myFrom).where(condicionCedula);

		TypedQuery<Alumno> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}

}
