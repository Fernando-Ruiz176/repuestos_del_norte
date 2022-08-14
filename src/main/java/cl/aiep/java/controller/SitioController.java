package cl.aiep.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SitioController {
	
	@GetMapping("/")
	public String index() {
		return "inicio";
	}
	
	@GetMapping("/nosotros")
	public String nosotros() {
		return "nosotros";
	}

}
