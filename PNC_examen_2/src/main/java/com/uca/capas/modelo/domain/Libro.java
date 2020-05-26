package com.uca.capas.modelo.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {
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
	@GeneratedValue(generator="cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_libro_c_libro_seq", sequenceName = "public.cat_libro_c_libro_seq", allocationSize = 1)
	@Column(name = "c_libro")
	private Integer c_libro;
	
	@Column(name = "s_titulo")
	@Size(message = "El nombre no debe tener mas de 500 caracteres", max = 500)
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String s_titulo;
	
	@Column(name = "s_autor")
	@Size(message = "El nombre no debe tener mas de 150 caracteres", max = 150)
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String s_autor;
	
	
	@Column(name = "s_isbn")
	@Size(message = "El nombre no debe tener mas de 10 caracteres", max = 10)
	@NotEmpty(message = "Este campo no puede estar vacio")
	private String s_isbn;
	
	@Column(name = "b_estado")
	private Boolean b_estado;
	
	@NotNull(message = "El campo Fecha no puede quedar vacio")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "f_ingreso")
	private Date f_ingreso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer c_categoria;
	
	public Libro() {}

	public Integer getC_libro() {return c_libro;}
	public void setC_libro(Integer c_libro) {this.c_libro = c_libro;}

	public String getS_titulo(){return s_titulo;}
	public void setS_titulo(String s_titulo) {this.s_titulo = s_titulo;}

	public String getS_autor(){return s_autor;}
	public void setS_autor(String s_autor) {this.s_autor = s_autor;}

	public String getS_isbn(){return s_isbn;}
	public void setS_isbn(String s_isbn) {this.s_isbn = s_isbn;}
	
	public Boolean getB_estado(){return b_estado;}
	public void setB_estado(Boolean b_estado) {this.b_estado = b_estado	;}
	
	public Date getF_ingreso() {return f_ingreso;}
	public String getF_ingresoDelegate() {SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	return formato.format(f_ingreso);}
	public void setF_ingreso(Date f_ingreso) {this.f_ingreso = f_ingreso;}

	public Categoria getCategoria() {return categoria;}
	public void setCategoria(Categoria categoria) {this.categoria = categoria;}

	public Integer getC_categoria() {return c_categoria;}
	public void setC_importancia(Integer c_categoria) {this.c_categoria = c_categoria;}

}
