package cl.aiep.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class UsuariosAutenticacion {
	
	@Bean
	public UserDetailsService usuarios() {
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		UserDetails usuario1 = userBuilder
			.username("admin@repdelnorte.cl")
			.password("admin123")
			.roles("ADMIN")
			.build()
		;
		
		UserDetails usuario2 = userBuilder
				.username("juan@repdelnorte.cl")
				.password("juan123")
				.roles("USER")
				.build()
		;
		
		UserDetails usuario3 = userBuilder
				.username("rosa@repdelnorte.cl")
				.password("rosa123")
				.roles("USER")
				.build()
				;
		
		return new InMemoryUserDetailsManager(usuario1, usuario2, usuario3);
	}

}
