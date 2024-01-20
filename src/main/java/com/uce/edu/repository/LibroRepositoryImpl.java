package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro libro) {

		this.entityManager.persist(libro);
	}

	@Override
	public void insertar(Libro2 libro2) {
		this.entityManager.persist(libro2);
	}

	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		// SQL ->Select * from libro l where l.libr_titulo = ?
		// JPQL -> SELECT l FROM Libro l WHERE l.titulo = : variable
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = : variable");
		myQuery.setParameter("variable", titulo);
		return (Libro) myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
		// SQL : SELECT * FROM libro l Where l.libr_fecha_publicacion >= ?
		// JPQL: SELECT l FROM Libro l WHERE l.fechaPublicacion >= :fecha
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >= :fecha");
		myQuery.setParameter("fecha", fechaPublicacion);
		return (List<Libro>)myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorNombreNative(String nombre) {
		Query myQuery = this.entityManager.
				createNativeQuery("SELECT * FROM libro l WHERE l.libr_titulo=:nombre",Libro.class);
		myQuery.setParameter("nombre", nombre);
		return (Libro) myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion) {
	TypedQuery<Libro > myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >= :fecha",Libro.class);
	myQuery.setParameter("fecha", fechaPublicacion);
	return myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
	TypedQuery<Libro> myQuery =	this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo",Libro.class);
	myQuery.setParameter("titulo", titulo);
	return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion) {
	TypedQuery<Libro> myQuery =	this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha", Libro.class);
	myQuery.setParameter("fecha", fechaPublicacion)	;
	return myQuery.getResultList();
	}
	

}
