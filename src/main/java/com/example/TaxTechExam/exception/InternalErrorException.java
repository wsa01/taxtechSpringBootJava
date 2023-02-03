package com.example.TaxTechExam.exception;

import com.example.TaxTechExam.enumeration.StatusEnum;
import com.example.TaxTechExam.response.StatusResponse;

import lombok.Getter;

@Getter
public class InternalErrorException extends RuntimeException{

	private final StatusResponse statusResponse;
	
	public InternalErrorException(StatusEnum status) {
		statusResponse = status.getStatus();
	}

	
}
