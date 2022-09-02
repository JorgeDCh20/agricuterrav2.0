package pe.edu.upc.agricuterra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.agricuterra.auth.handler.LoginSucessHandler;
import pe.edu.upc.agricuterra.serviceimplements.JpaUserDetailsService;

@SuppressWarnings("deprecation")
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private LoginSucessHandler sucessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		// Para permitir nuestro js y css (en nuestra carpeta static)
		.antMatchers("/*.js", "/*.css").permitAll()		
		// Para que solo un usuario logueado con esos roles acceda a /home
		.antMatchers("/home").access("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_AGRICULTOR')or hasRole('ROLE_ESPECIALISTA')or hasRole('ROLE_EMPRESARIO')or hasRole('ROLE_PRUEBA')")
		.and().formLogin().successHandler(sucessHandler).loginPage("/").loginProcessingUrl("/")
		// Si el login es exitoso, retorna a /home
		.defaultSuccessUrl("/home").permitAll().and().logout().logoutSuccessUrl("/login").permitAll()
		// Si el usuario va a una ruta sin acceso, devuelve a /error_403 (Configurado en MvcConfig)
		.and().exceptionHandling().accessDeniedPage("/error403");

	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {

		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

	}
}
