package com.uca.capas.modelo.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.capas.modelo.domain.Categoria;
import com.uca.capas.modelo.domain.Libro;

public interface CategoriaService {
	
	public List<Categoria> findAll() throws DataAccessException;
	
	public Categoria findOne(Integer cimportancia) throws DataAccessException;
	
	public void saveCategoria(Categoria c) throws DataAccessException;


}
