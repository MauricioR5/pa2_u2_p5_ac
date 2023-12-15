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
@Table(name = "automovil")
public class Automovil {
	@SequenceGenerator(name = "seq_automovil", sequenceName = "seq_automovil", allocationSize = 1)
	@GeneratedValue(generator = "seq_automovil", strategy = GenerationType.SEQUENCE)
	@Id
	
	@Column(name = "auto_id")
	private Integer id;
	
	@Column(name = "auto_placa")
	private String placa;
	
	@Column(name = "auto_marca")
	private String marca;
	
	@Column(name = "auto_anio")
	private LocalDateTime anio;
	
	@Column(name = "auto_modelo")
	private String modelo;
	
	//set and get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public LocalDateTime getAnio() {
		return anio;
	}

	public void setAnio(LocalDateTime anio) {
		this.anio = anio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	

}
