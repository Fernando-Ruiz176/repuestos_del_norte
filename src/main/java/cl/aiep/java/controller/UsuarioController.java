package cl.aiep.java.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.java.model.Usuario;
import cl.aiep.java.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@GetMapping("/contratado")
	public String usuarioContratado(Usuario usuario) {
		return "usuario/nuevo";
	}
	
	@PostMapping("/nuevo")
	public String usuarioProcesar(@Valid Usuario usuario, BindingResult informeValidacion) {
		if (informeValidacion.hasErrors() ) {
			return "usuario/nuevo";
		}
		if (usuario.getId() == 0 ) {
			usuarioRepository.create(usuario);
		} else {
			usuarioRepository.edit(usuario);
		}
		return "usuario/ficha";
	}
	
	
	
	

}
