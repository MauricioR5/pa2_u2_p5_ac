package com.uce.edu.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentabancaria")
public class CuentaBancaria {
	
	@Id
	@Column(name = "cta_id")
	private Integer id;
	
	@Column(name = "cta_numero")
	private String numero;
	
	@Column(name = "cta_cedula_propietario")
	private String cedulaPropietario;
	
	@Column(name = "cta_saldo")
	private BigDecimal saldo;

}
