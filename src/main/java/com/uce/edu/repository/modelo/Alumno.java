package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")

public class Alumno {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="seq_alumno")
	@SequenceGenerator(name="seq_alumno",sequenceName = "seq_alumno",allocationSize = 1)
	
	@Id
	@Column(name="alum_id")
	private Integer id;
	@Column(name="alum_nombre")
	private String nombre;
	
	@Column(name = "alum_apellido")
	private String apellido;
	
	@Column(name = "alum_cedula")
	private String cedula;
	
	//set get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + "]";
	}
	
	
	

}
