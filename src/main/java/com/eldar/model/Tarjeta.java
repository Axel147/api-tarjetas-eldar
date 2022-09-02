package com.eldar.model;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Tarjeta {
	private final String marca;
	private final String numTarjeta;
	private final String cardHolder;
	private final Calendar fechaVencimiento;
	
	public Tarjeta(String marca, String numTarjeta, String cardHolder, Calendar fechaVencimiento) {
		checkNullParams(marca, numTarjeta, cardHolder, fechaVencimiento);
		this.marca = marca;
		this.numTarjeta = numTarjeta;
		this.cardHolder = cardHolder;
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public boolean operacionValida(int consumo) {
		return consumo < 1000;
	}
	
	public boolean tarjetaValida() {
		Calendar hoy = new GregorianCalendar();
		return hoy.before(getFechaVencimiento());
	}
	
	public abstract float calcularTasa(float importe);
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Tarjeta)) {
			return false;
		} else {
			Tarjeta t2 = (Tarjeta) o;
			return Objects.equals(this.getNumTarjeta(), t2.getNumTarjeta());
		}
	}
	
	public void checkNullParams(Object ...params) {
		for(Object o : params) {
			if(o == null) {
				throw new NullPointerException("Param(s) can't be null");
			}
		}
	}
	
	public void informacion() {
		System.out.println("Marca: " +getMarca() + "\nNumero Tarjeta: " +getNumTarjeta() + "\nCardHolder: " +getCardHolder() + "\nFecha Vencimiento: " +getFechaVencimiento());
	}
	
	public String getMarca() {
		return marca;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public Calendar getFechaVencimiento() {
		return fechaVencimiento;
	}
	
}
