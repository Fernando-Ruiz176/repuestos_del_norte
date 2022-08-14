package cl.aiep.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cl.aiep.java.model.Categoria;
import cl.aiep.java.model.Cliente;
import cl.aiep.java.model.Producto;
import cl.aiep.java.model.Usuario;
import cl.aiep.java.repository.CategoriaRepository;
import cl.aiep.java.repository.ClienteRepository;
import cl.aiep.java.repository.ProductoRepository;
import cl.aiep.java.repository.UsuarioRepository;

@SpringBootApplication
public class RepuestosDelNorteApplication implements WebMvcConfigurer{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RepuestosDelNorteApplication.class, args);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new Converter<String, Categoria>() {

			@Override
			public Categoria convert(String strFieldFormCategoriaId) {
				int id = Integer.parseInt(strFieldFormCategoriaId);
				Categoria categoria = categoriaRepository.findById((long) id);
				return categoria;
			}
			
		});
		
		registry.addConverter(new Converter<String, Cliente>() {

			@Override
			public Cliente convert(String strFieldFormClienteId) {
				int id	=	Integer.parseInt(strFieldFormClienteId);
				Cliente cliente = clienteRepository.findById((long) id);
				return cliente;
			}
			
		});
		
		registry.addConverter(new Converter<String, Usuario>() {
			
			@Override
			public Usuario convert(String strFieldFormVendedorId) {
				int id	=	Integer.parseInt(strFieldFormVendedorId);
				Usuario usuario = usuarioRepository.findById((long) id);
				return usuario;
			}
			
		});
		
		registry.addConverter(new Converter<String, Producto>() {
			
			@Override
			public Producto convert(String strFieldFormProductoId) {
				int id	=	Integer.parseInt(strFieldFormProductoId);
				Producto producto = productoRepository.findById((long) id);
				return producto;
			}
			
		});
		
	}

}
