package com.jasonswitzer.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jasonswitzer.dojosandninjas.models.*;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>, PagingAndSortingRepository<Ninja, Long> {
	List<Ninja> findByDojo(Dojo dojo);

}
