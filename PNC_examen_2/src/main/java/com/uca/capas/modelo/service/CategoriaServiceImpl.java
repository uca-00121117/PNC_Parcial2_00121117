package com.uca.capas.modelo.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.modelo.dao.CategoriaDAO;
import com.uca.capas.modelo.domain.Categoria;
import com.uca.capas.modelo.domain.Libro;
/*
(Clase 15)-> @Service: Esta anotación le dicta a Spring que dicha clase es de Servicio, 
con lo cual se podrá manejar los métodos dentro de transacciones
*/
@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDAO.findAll();
	}

	@Override
	public Categoria findOne(Integer c_importancia) throws DataAccessException {
		return categoriaDAO.findOne(c_importancia);
	}
	@Override
	@Transactional
	public void saveCategoria(Categoria c) throws DataAccessException {
	
		categoriaDAO.saveCategoria(c);	
		
	}
}
