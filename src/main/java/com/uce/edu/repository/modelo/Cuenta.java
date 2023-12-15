package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "cuenta")
@Entity
public class Cuenta {

	@GeneratedValue(generator = "seq_cuenta", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_cuenta", sequenceName = "seq_cuenta", allocationSize = 1)
	@Id
	@Column(name = "cuenta_id")
	private Integer id;

	@Column(name = "cuenta_num")
	private String numero;

	@Column(name = "cuenta_tipo")
	private String tipo;

	@Column(name = "cuenta_fecha")
	private LocalDateTime fechaApertura;

	@Column(name = "cuenta_saldo")
	private BigDecimal saldo;
	
	//set and get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDateTime fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	
}
