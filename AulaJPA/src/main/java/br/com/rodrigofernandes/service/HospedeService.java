package br.com.rodrigofernandes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rodrigofernandes.model.Hospede;
import br.com.rodrigofernandes.repository.HospedeRepository;

@Service
@Transactional
public class HospedeService {
	
	@Autowired
	private HospedeRepository rep;
	
	public List<Hospede> todos(){
		return rep.findAll();
	}
	
	public void salvar(Hospede hospede) {
		rep.save(hospede);
	}
	
	public Hospede buscarHospede(Long id) {
		return rep.findById(id).get();
	}
	
	public void excluirHospede(Long id) {
		rep.deleteById(id);
	}

}
