package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Hotel hotel) {
		this.entityManager.persist(hotel);
	}

	@Override
	public Hotel seleccionarPorNombre(String nombre) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h WHERE h.nombre = : nombre",Hotel.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Hotel seleccionarPorNombreNative(String nombre) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM hotel h WHERE h.hote_nombre =:nombre", Hotel.class);
		myQuery.setParameter("nombre", nombre);
		return (Hotel)myQuery.getSingleResult();
	}

	@Override
	public List<Habitacion> seleccionarHabitacion(String nombre) {
		TypedQuery<Habitacion> myQuery = this.entityManager
				.createQuery("SELECT h FROM Habitacion h WHERE h.hotel.nombre =:nombre", Habitacion.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public Hotel seleccionarPorCriteria(String nombre) {
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Hotel> myCriteriaQuery = myCriteriaBuilder.createQuery(Hotel.class);

		Root<Hotel> myFrom = myCriteriaQuery.from(Hotel.class);

		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		myCriteriaQuery.select(myFrom).where(condicionNombre);

		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getSingleResult();
	}

}
