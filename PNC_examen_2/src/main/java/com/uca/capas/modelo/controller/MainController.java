package com.uca.capas.modelo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.modelo.domain.Libro;	
import com.uca.capas.modelo.domain.Categoria;
import com.uca.capas.modelo.service.LibroService;
import com.uca.capas.modelo.service.CategoriaService;


@Controller
public class MainController {
	
	@Autowired
	LibroService libroService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/IngresarCategoria")
	public ModelAndView ingresarCat() {
		ModelAndView mav = new ModelAndView();
		//lista de elementos que obtenemos de la base de datos
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		mav.setViewName("IngresarCategoria");
		
		return mav;
	}

	@RequestMapping("/IngresarLibro")
	public ModelAndView ingresarLib() {
		ModelAndView mav = new ModelAndView();
		//lista de elementos que obtenemos de la base de datos
		List<Categoria> categorias = categoriaService.findAll();
		Libro libro = new Libro();
		mav.addObject("categorias", categorias);
		mav.addObject("libro", libro);
		mav.setViewName("IngresarLibro");
		return mav;
	}
	
	
	@RequestMapping("/guardarLibro")
	public ModelAndView guardarlibro(@Valid @ModelAttribute Libro c,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(!result.hasErrors()) {
			try {
				libroService.save(c);
				mav.setViewName("exito");
				return mav;
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		
		}
		List<Categoria> categorias = categoriaService.findAll();
		mav.addObject("categorias", categorias);
		mav.setViewName("IngresarLibro");
		return mav;

	}
	
	@RequestMapping("/guardarLibro2")
	public ModelAndView guardar2(@ModelAttribute Libro c,BindingResult result) {
		ModelAndView mav = new ModelAndView();
				libroService.save(c);
				mav.setViewName("exito");
		return mav;

	}
	@RequestMapping("/guardarCategoria")
	public ModelAndView guardar(@Valid @ModelAttribute Categoria c,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(!result.hasErrors()) {
			try {
				categoriaService.saveCategoria(c);
			}catch (Exception e) {
				e.printStackTrace();
			}
			Categoria categoria=new Categoria();
			mav.addObject("categoria", categoria);
			mav.setViewName("exito");
			return mav;
		}
		mav.setViewName("IngresarCategoria");
		return mav;
	}
	
	@RequestMapping("/libros")
	public ModelAndView lista() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = libroService.findAll();
		mav.addObject("libros", libros);
		mav.setViewName("libros");
		return mav;
	}

}
