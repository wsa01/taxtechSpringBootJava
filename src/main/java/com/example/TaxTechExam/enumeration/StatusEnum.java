package com.example.TaxTechExam.enumeration;

import com.example.TaxTechExam.response.StatusResponse;

import lombok.Getter;

@Getter
public enum StatusEnum {

	OK("201","Proceso Exitoso"),
	FAIL("202", "Proceso Fallido"),
	CLIENT_EXIST("901","El cliente ya existe"),
	CLIENT_NOT_EXIST("902","El cliente No existe")
	;
	
	private final StatusResponse status;
	
	private StatusEnum(String code, String message) {
		status = StatusResponse.builder().code(code).message(message).build();
	}
	
}
