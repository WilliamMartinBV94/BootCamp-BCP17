package com.NTTDATA.BootCamp.model;

public class RegistrarSolicitudResponse {
	private String DNI;
	private String montoRetiro;
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getMontoRetiro() {
		return montoRetiro;
	}
	public void setMontoRetiro(String montoRetiro) {
		this.montoRetiro = montoRetiro;
	}
	public String getAFP() {
		return AFP;
	}
	public void setAFP(String aFP) {
		AFP = aFP;
	}
	private String AFP;

}
