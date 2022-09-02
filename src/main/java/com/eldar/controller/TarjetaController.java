package com.eldar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.lang.reflect.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.eldar.dto.CalculoTasaDTO;
import com.eldar.model.Tarjeta;


@RestController
@RequestMapping("/tarjeta")
@CrossOrigin("*")
@ResponseBody
public class TarjetaController {
	
	
	@GetMapping("/calcularTasa")
	public ResponseEntity<String> obtenerTasa(@RequestBody CalculoTasaDTO calculoTasaDTO) {
		if(calculoTasaDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
		}
		Class<?> c;
		try {
			c = Class.forName("com.eldar.model." + calculoTasaDTO.marca);	
		}catch (ClassNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Marca invalida");
		}
		try {
			Constructor<?> c2 = c.getConstructor(new Class[] {String.class, String.class, String.class, Calendar.class});
			Tarjeta t = (Tarjeta) c2.newInstance(new Object[] {calculoTasaDTO.marca,"4459 3242 3046 2139", "Alexis Lewis", new GregorianCalendar(2024,2,1)});
			float result = t.calcularTasa(calculoTasaDTO.importe);
			return ResponseEntity.status(HttpStatus.OK).body(Float.toString(result));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
		}
	}

}
