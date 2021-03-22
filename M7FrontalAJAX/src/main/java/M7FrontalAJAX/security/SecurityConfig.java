package M7FrontalAJAX.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
            .antMatchers("/oauth/token").permitAll() //permitimos el acceso a /oauth/login a cualquiera
            .anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
            .and()
            // Las peticiones /login pasaran previamente por este filtro
            .addFilterBefore(new LoginFilter("/oauth/token", authenticationManager()),
                    UsernamePasswordAuthenticationFilter.class)

            // Las demás peticiones pasarán por este filtro para validar el token
            .addFilterBefore(new JwtFilter(),
                    UsernamePasswordAuthenticationFilter.class);
    }

   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Creamos una cuenta de usuario por default
       auth.inMemoryAuthentication()
               .withUser("firstuser")
               .password("{noop}123")
               .roles("ADMIN");
       
       auth.inMemoryAuthentication()
			   .withUser("myroslav")
			   .password("{noop}myroslav")
			   .roles("USER");
    }
   
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		List<String> allowedMethods = new ArrayList<String>();
		allowedMethods.add("DELETE");
		allowedMethods.add("PUT");
		allowedMethods.add("GET");
		allowedMethods.add("POST");
		
		CorsConfiguration myCorsConfiguration = new CorsConfiguration();
		myCorsConfiguration.applyPermitDefaultValues().setAllowedMethods(allowedMethods);;
		
		source.registerCorsConfiguration("/**", new CorsConfiguration().combine(myCorsConfiguration));
		return source;
	}
	
}
