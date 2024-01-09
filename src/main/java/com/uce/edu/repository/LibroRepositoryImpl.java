package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
		//SQL ->Select * from libro l where l.libr_titulo = ?
		//JPQL -> SELECT l FROM Libro l WHERE l.titulo = : variable
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = : variable");
		myQuery.setParameter("variable", titulo);
		return (Libro)myQuery.getSingleResult();
	}

}
