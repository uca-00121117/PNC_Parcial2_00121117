package com.uca.capas.modelo.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.capas.modelo.domain.Libro;

public interface LibroService {
	
	public List<Libro> findAll() throws DataAccessException;
	
	public void save(Libro c) throws DataAccessException;

}
