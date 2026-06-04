package om.May2026.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.May2026.demo.service.CustomUserDetailService;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailService customUserDetailsService;
	
@Bean	
public PasswordEncoder passwordEncoder()
{
	return new BCryptPasswordEncoder(12);
}

@Bean
public AuthenticationProvider authenticationProvider()
{
	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(customUserDetailsService);

	authProvider.setPasswordEncoder(passwordEncoder());
	return authProvider;
}


@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
{
	http.csrf(csrf->csrf.disable())
	    .cors(cors -> cors.disable())
	.authenticationProvider(authenticationProvider())
	.authorizeHttpRequests(auth->auth
			.dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()
			.requestMatchers("/employee/**").hasAnyRole("USER","ADMIN")
			.requestMatchers("/departments/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			 )
	.httpBasic(Customizer.withDefaults())
	.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	
	
	return http.build();
}

}
