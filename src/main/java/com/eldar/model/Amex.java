package com.eldar.model;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Amex extends Tarjeta{
	
	public Amex(String marca, String numTarjeta, String cardHolder, Calendar fechaVencimiento) {
		super(marca, numTarjeta, cardHolder, fechaVencimiento);
	}
	
	@Override
	public float calcularTasa(float importe) {
		Calendar hoy = new GregorianCalendar();
		return importe + hoy.get((Calendar.MONTH)+1) * (float) 0.1;
	}
	
}
