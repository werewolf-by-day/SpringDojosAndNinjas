package com.jasonswitzer.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jasonswitzer.dojosandninjas.models.Dojo;
import com.jasonswitzer.dojosandninjas.models.Ninja;
import com.jasonswitzer.dojosandninjas.repositories.NinjaRepository;

@Service
@Transactional
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepository;
	
	private static final int PAGE_SIZE = 5;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Page<Ninja> ninjasPerPage(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, 
				Sort.Direction.ASC, "dojo.name");
		return ninjaRepository.findAll(pageRequest);
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
	public List<Ninja> getNinjasAtDojo(Dojo dojo) {
		return ninjaRepository.findByDojo(dojo);
	}
}
