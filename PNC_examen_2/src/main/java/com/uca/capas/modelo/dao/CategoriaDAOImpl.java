package com.uca.capas.modelo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.capas.modelo.domain.Categoria;
import com.uca.capas.modelo.domain.Libro;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {
	/*
	 * Definimos el objeto EntityManager con el cual ejecutaremos
	 * consultas a la base de datos, para esto utilizamos la anotacion
	 * @PersistenceContext, al cual le definimos el nombre de la unidad
	 * de persistencia que le fue asignado en la clase JpaConfiguration (linea 21)
	 * con la propiedad unitName, con esto tenemos el objeto EntityManager
	 * de la base de datos definida en nuestra clase de configuracion de Jpa
	 */
	@PersistenceContext(unitName = "modelo-persistence")
	EntityManager entityManager;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		//Creamos un objeto StringBuffer para definir la consulta a ejecutar
		StringBuffer sb = new StringBuffer();
		//Definimos la consulta con el metodo append
		sb.append("select * from public.cat_categoria");
		/*
		 * Declaramos un objeto de tipo javax.persistence.Query, el cual representa a la consulta
		 * Dicho objeto no lo instanciamos, sino que le asignamos lo que devuelve el metodo
		 * createNativeQuery del entityManager, el cual recibe dos parametros
		 * 1. La consulta de tipo String
		 * 2. La referencia de la clase a la que queremos mapear el resultado (importancia)
		 */
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		/*
		 * Ejecutamos la consulta con el metodo getResultList() de nuestro objeto Query
		 * el cual devolvera una lista del tipo definido anteriormente (importancia.class)
		 * y lo asignamos a una lista de tipo cliente
		 */
		List<Categoria> res = query.getResultList();
		return res;
	}

	@Override
	public Categoria findOne(Integer c_categoria) throws DataAccessException {
		
		Categoria imp = entityManager.find(Categoria.class, c_categoria);
		return imp;
	}
	@Override
	public void saveCategoria(Categoria c) throws DataAccessException {
		 //Si la propiedad de la llave primaria viene vacío, entonces es un INSERT
		//Utilizamos persist ya que es un INSERT
		entityManager.persist(c);
	}
}
