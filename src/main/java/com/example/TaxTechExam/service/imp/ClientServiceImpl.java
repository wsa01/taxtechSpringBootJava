package com.example.TaxTechExam.service.imp;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaxTechExam.enumeration.StatusEnum;
import com.example.TaxTechExam.exception.InternalErrorException;
import com.example.TaxTechExam.model.ClientModel;
import com.example.TaxTechExam.repository.ClientRepository;
import com.example.TaxTechExam.request.ClientReq;
import com.example.TaxTechExam.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<ClientModel> list() {
		List<ClientModel> result = (List<ClientModel>) clientRepo.findAll();
		return result;
	}


	@Override
	public void createClient(ClientReq clientReq) {
		
		List<ClientModel> result = clientRepo.findAll();
		boolean exit = result.stream().anyMatch(clients -> clientReq.getDni().equals(clients.getDni()));
		
		if(exit) {
			throw new InternalErrorException(StatusEnum.CLIENT_EXIST);
		}
		
		ClientModel modelMp = modelMapper.map(clientReq, ClientModel.class);
		clientRepo.save(modelMp);
		
	}


	@Override
	public void deleteClient(String dni) {
		clientRepo.deleteByDni(dni);
	}


	@Override
	public void updateClient(ClientReq clientReq) {
		
		ClientModel client = clientRepo.findAll().stream()
				.filter(cli -> cli.getDni().equals(clientReq.getDni()))
				.findAny()
				.orElse(null);
		
		if (client==null) {
			throw new InternalErrorException(StatusEnum.CLIENT_NOT_EXIST);
		}
	
		client.setApellido(clientReq.getApellido());
		client.setEdad(clientReq.getEdad());
		client.setNombre(clientReq.getNombre());
		client.setFechNac(clientReq.getFechNac());
		
		clientRepo.save(client);
		
		
	}

	




}
