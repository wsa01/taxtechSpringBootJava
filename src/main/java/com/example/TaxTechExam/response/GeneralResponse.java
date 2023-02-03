package com.example.TaxTechExam.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GeneralResponse<T> {
	private StatusResponse status;
	private T data;
}
