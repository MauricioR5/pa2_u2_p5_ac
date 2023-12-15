package com.uce.edu.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "propietario")
public class Propietario {
	
	@SequenceGenerator(name = "seq_propietario", sequenceName = "seq_propietario",allocationSize = 1)
	@GeneratedValue(generator = "seq_propietario",strategy = GenerationType.SEQUENCE)
	@Id
	
	@Column(name = "prop_id")
	private Integer id;
	
	@Column(name = "prop_cedula")
	private String cedula;
	
	@Column(name = "prop_direccion")
	private String direccion;
	
	@Column(name = "prop_nivel_acceso")
	private Integer nivelAcceso;
	
	@Column(name = "prop_fecha_ingreso")
	private LocalDateTime fechaIngreso;
	
	//set and get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getNivelAcceso() {
		return nivelAcceso;
	}

	public void setNivelAcceso(Integer nivelAcceso) {
		this.nivelAcceso = nivelAcceso;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	

}
