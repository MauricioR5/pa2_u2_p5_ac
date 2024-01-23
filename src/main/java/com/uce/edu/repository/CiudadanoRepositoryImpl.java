package com.uce.edu.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

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
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		this.entityManager.persist(ciudadano);

	}

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		// TypedQuery<Empleado> myQuery = this.entityManager.createQuery("SELECT e FROM
		// Empleado e WHERE e.ciudadano.cedula", Empleado.class);
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula =:cedula", Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCedulaCiud(String cedula) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula =:cedula",
				Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorApellido(String apellido) {
		// 0. Creamos una instancia de la interfaz Criteria Builder a partir de un
		// entityaManager

		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		// 1. Determinamos el tipo de retorno que tendrá la consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);

		// 2. Construir el SQL
		// 2.1. Determinamos el from(Root)
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);// From Ciudadano
		// Nota: No necesariamente el From es igual al tipo de retorno
		// SELECT From Ciudadano c WHERE c.nombre =: dato
		// 2.2.Construir las condiciones (WHERE) del SQL
		//En Criteria Api Query, las condiciones se las conoce como "Predicate"
		//c.apellido =:variable
		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
		//3.Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionApellido);
		
		//4. Ejecutamos la consulta con un TypedQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
		
		Predicate condicionGenerica = null;
		if(cedula.startsWith("17")){
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		}else if(cedula.startsWith("05")){
			 condicionGenerica = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);

		}else {
			 condicionGenerica = myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);

		}
		myCriteriaQuery.select(myFrom).where(condicionGenerica);
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
		
		Predicate condicionTotal = null;
		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);

		
		if(cedula.startsWith("17")){
			condicionTotal = myCriteriaBuilder.or(condicionNombre,condicionApellido);
		}else if(cedula.startsWith("05")){
			condicionTotal = myCriteriaBuilder.and(condicionNombre,condicionApellido);
		
		}
		myCriteriaQuery.select(myFrom).where(condicionTotal);
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

}
