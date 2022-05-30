package com.NTTDATA.BootCamp.model;

import java.sql.Date;

public class RegistarSolicitudAFP {
	private String DNI;
	private String montoDisponible;
	private Date fechaRetiro;
	private String nroCuenta;
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getMontoDisponible() {
		return montoDisponible;
	}
	public void setMontoDisponible(String montoDisponible) {
		this.montoDisponible = montoDisponible;
	}
	public Date getFechaRetiro() {
		return fechaRetiro;
	}
	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}
	public String getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	

}
