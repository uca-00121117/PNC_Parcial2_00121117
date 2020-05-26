package com.uca.capas.modelo.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "cat_categoria")
public class Categoria {
	//(Clase 15)->@GeneratedValue: Se utiliza para anotar a la propiedad que actúa como llave primaria 
	//(por ende la que está anotada con @Id). La propiedad generator define el nombre del 
	//generador que se utilizará para insertar valores secuenciales a la propiedad.
	//Strategy define la estrategia con la que se generará el valor, en nuestro caso lo dejaremos en AUTO.

	//(Clase 15)->@SequenceGenerator: Se define la secuencia a la que estará haciendo referencia
	//la anotación GeneratedValue. La propiedad name define el nombre con la que se
	//referenciará esta secuencia (es la que también se define en la propiedad generator 
	//de la anotación GeneratedValue, y la propiedad sequenceName define el nombre de la
	//secuencia en la base de datos (esquema incluido)
	@Id
	@GeneratedValue(generator="cat_categoria_c_categoria_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_categoria_c_categoria_seq", sequenceName = "public.cat_categoria_c_categoria_seq", allocationSize = 1)
	@Column(name = "c_categoria")
	private Integer c_categoria;
	
	@Column(name = "s_categoria")
	@Size(message = "El nombre no debe tener mas de 50 caracteres", max = 50)
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String s_categoria;
	
	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Libro> libros;

	public Integer getC_categoria() {return c_categoria;}
	public void setC_categoria(Integer c_categoria) {	this.c_categoria = c_categoria;}

	public String getS_categoria() {return s_categoria;	}
	public void setS_categoria(String s_categoria) {this.s_categoria = s_categoria;	}

	public List<Libro> getLibros() {return libros;}

	public void setLibros(List<Libro> libros) {this.libros = libros;}

}
