package com.algaworks.brewer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.algaworks.brewer.security.AppUserDetailsService;

	
@EnableWebSecurity
@ComponentScan(basePackageClasses = AppUserDetailsService.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private UserDetailsService userDetailsService;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
			
//			auth.inMemoryAuthentication()
//			.withUser("admin").password("admin").roles("CADASTRO_CLIENTE");
			
		}
		
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring()
				.antMatchers("/layout/**")
				.antMatchers("/images/**");
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
				    .antMatchers("/cidades/nova").hasRole("CADASTRAR_CIDADE")		//se Não quiser meter role_* na BD posso usar o hasAuthority() ou usar "Role_" + p.toUpper no AppUserDetailsService.
				    .antMatchers("/usuarios/**").hasRole("CADASTRAR_USUARIO")
					.anyRequest().authenticated()
					.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.and()	
				.exceptionHandling()
					.accessDeniedPage("/403")
					.and()
				.sessionManagement()											// para introduzir um maximo de sessoes a poderem estar abertas, posso redirecionar para uma página 
					.maximumSessions(1)
					.expiredUrl("/login")
					.and()
					.invalidSessionUrl("/login");
						
			
			
		}
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

	}