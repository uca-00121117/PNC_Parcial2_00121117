package com.uca.capas.modelo.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.capas.modelo.domain.Categoria;
import com.uca.capas.modelo.domain.Libro;


public interface CategoriaDAO {
	
	public List<Categoria> findAll() throws DataAccessException;
	
	public Categoria findOne(Integer c) throws DataAccessException;
	
	public void saveCategoria(Categoria c) throws DataAccessException;


}
