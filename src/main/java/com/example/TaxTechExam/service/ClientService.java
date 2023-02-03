package com.example.TaxTechExam.service;

import java.util.List;

import com.example.TaxTechExam.model.ClientModel;
import com.example.TaxTechExam.request.ClientReq;

public interface ClientService {

	public List<ClientModel> list();
	public void createClient(ClientReq clientReq);
	public void deleteClient(String dni);
	public void updateClient(ClientReq clientReq);

}
