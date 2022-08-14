package cl.aiep.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.java.model.Categoria;
import cl.aiep.java.repository.CategoriaRepository;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public String categoriaNueva(Categoria categoria) {
		return "categoria/form";
	}
	
	
	
	
	
	

}
