package com.uca.capas.modelo.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.capas.modelo.domain.Libro;

public interface LibroDAO {
	
	public List<Libro> findAll() throws DataAccessException;
	
	public void save(Libro c) throws DataAccessException;

}
