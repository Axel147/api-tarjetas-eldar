package com.eldar.model;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Nara extends Tarjeta{

	public Nara(String marca, String numTarjeta, String cardHolder, Calendar fechaVencimiento) {
		super(marca, numTarjeta, cardHolder, fechaVencimiento);
	}

	@Override
	public float calcularTasa(float importe) {
		Calendar hoy = new GregorianCalendar();
		return importe + hoy.get(Calendar.DAY_OF_MONTH) * (float) 0.5;
	}

}
