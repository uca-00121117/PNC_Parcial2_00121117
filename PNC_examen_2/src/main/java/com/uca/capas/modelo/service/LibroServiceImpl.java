package com.uca.capas.modelo.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uca.capas.modelo.dao.LibroDAO;
import com.uca.capas.modelo.domain.Libro;
/*
 (Clase 15)-> @Service: Esta anotación le dicta a Spring que dicha clase es de Servicio, 
 con lo cual se podrá manejar los métodos dentro de transacciones
 */
@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	LibroDAO LibroDAO;
	
	@Autowired
	CategoriaService CategoriaService;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		return LibroDAO.findAll();
	}
/*
 * C 15
  El método save está siendo anotado por @Transactional, 
  esto debido a que como es una operación de persistencia la que se realizará 
  (INSERT o UPDATE) Spring necesita realizarlo dentro de una Transacción, 
  caso contrario, nos lanzará una excepción mencionando que no hay Transacción en curso.
 */
	@Override
	@Transactional
	public void save(Libro c) throws DataAccessException {

		LibroDAO.save(c);	
		
	}

}
