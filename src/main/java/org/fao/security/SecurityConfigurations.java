package org.fao.security;

import java.util.Arrays;

import org.fao.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
/*
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
	
	
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UtilizadorRepository repository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	//autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	// autorizacao
	
	protected void configure(HttpSecurity http) throws Exception {
	    http.cors()
	        .and()
	        .authorizeHttpRequests()
	        .anyRequest().permitAll() // Libera todos os endpoints
	        .and()
	        .csrf().disable();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and().authorizeRequests()
				//.antMatchers(HttpMethod.GET,"/tecnicos/**").hasAnyAuthority("Buscar_Tecnicos")
				.antMatchers(HttpMethod.GET, "/deposito").permitAll()
				.anyRequest().authenticated()
				.and().csrf().disable();
				//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				//.and().addFilterBefore(new AutenticacaoVaToken(tokenService, repository), UsernamePasswordAuthenticationFilter.class);
				//.exceptionHandling().accessDeniedHandler(new TratamentoErro403());;
				
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/**.html","/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
			
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	/*
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
}*/
