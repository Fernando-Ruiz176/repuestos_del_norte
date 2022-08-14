package cl.aiep.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import cl.aiep.java.model.Cliente;
import cl.aiep.java.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/nuevo")
	public String nuevoCliente(Cliente cliente) {
		return "cliente/form";
	}
	
	@PostMapping("/procesar")
	public String procesarAutor(@Valid Cliente cliente, BindingResult validacion) {
		
		if(validacion.hasErrors()) {
			return "cliente/form";
		}
		if(cliente.getId() > 0) {
			clienteRepository.edit(cliente);
			
		}else {
			
			clienteRepository.create(cliente);
		}
		return"redirect:/cliente/listado";
	}
	
	@GetMapping("/listado")
	public String listarCliente(Model modelo) {
		List<Cliente> clientes = clienteRepository.findAll();
		modelo.addAttribute("clientes", clientes);
		return "cliente/listado";
	}
	
	@GetMapping("/editar/{id}")
	public String editarCliente(@PathVariable Long id , Model modelo) {
		Cliente cliente = clienteRepository.findById(id);
		modelo.addAttribute("cliente", cliente);
		return "cliente/form";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam(name="id", required = true)Long id) {
		clienteRepository.delete(id);
		return "redirect:/cliente/listado";
	}

}
