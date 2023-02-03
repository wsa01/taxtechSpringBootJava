package com.example.TaxTechExam.request;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ClientReq {
	
	@NotEmpty
	private String nombre;
	private String apellido;
	@Min(value = 1,message = "La edad minima es 1 año")
	@Max(value = 120, message = "La edad maxima es de 120 años")
	private int edad;
	private LocalDate fechNac;
	@Size(max = 8,min = 8, message = "El numero de dni debe tener 8 digitos")
	private String dni;
}
