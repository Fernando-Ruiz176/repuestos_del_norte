package cl.aiep.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests(authorize -> authorize
				.mvcMatchers("/", "/nosotros").permitAll()
				.mvcMatchers("/", "/nosotros", "/usuario/**").hasRole("User")
				.mvcMatchers("/", "/nosotros", "/admin/**").hasRole("admin")
				.anyRequest().authenticated())
		
		.formLogin(form -> form 
				.loginPage("/ingreso")
				.defaultSuccessUrl("/", true)
				.permitAll()
			)
		
		.logout(logout -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
				);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
			.mvcMatchers("/img/**", "/css/**", "/js/**")
		;
	}
	

}
