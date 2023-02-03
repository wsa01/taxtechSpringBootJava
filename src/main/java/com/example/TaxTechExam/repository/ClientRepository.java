package com.example.TaxTechExam.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TaxTechExam.model.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Integer>{

	@Transactional
	public void deleteByDni(String dni);
	
	
}
