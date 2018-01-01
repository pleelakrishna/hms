package com.evoke.hms.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.evoke.hms.services.CustomUserDetailsService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	CustomUserDetailsService customUserDetailsService;

	/**
	 * Providing authentication based on datasource
	 */

	@Override
	public void configure( WebSecurity web ) throws Exception
	{
		// This is here to ensure that the static content (JavaScript, CSS, etc)
		// is accessible from the login page without authentication
		web
		.ignoring()
		.antMatchers( "/WEB-INF/jsp/**" )
		.antMatchers("/WEB-INF/css/**")
		.antMatchers("**/css/**");

	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {

		log.info("Using custom authentications service");
		//auth.inMemoryAuthentication().withUser("testuser").password("password").roles("ADMIN");
		auth.userDetailsService(customUserDetailsService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http

		// access-denied-page: this is the page users will be
		// redirected to when they try to access protected areas.
		.exceptionHandling()
		.accessDeniedPage( "/accessdenied" )
		.and()
		// The intercept-url configuration is where we specify what roles are allowed access to what areas.
		.authorizeRequests()
		.antMatchers("/**").permitAll()
		/*.antMatchers("/hms**").permitAll()
		.antMatchers("/index**").permitAll()
		.antMatchers("/login**").permitAll()
		.antMatchers("/homepage**").permitAll()
		.antMatchers("/searchprofile**").hasRole("ADMIN")
		.antMatchers("/editprofile**").hasRole("ADMIN")
		.antMatchers("/deleteprofile**").hasRole("ADMIN")
		.antMatchers("//updateprofile**").hasRole("ADMIN")
		.antMatchers("/accessdenied**").permitAll()
		.antMatchers("/registration**").permitAll()
		.antMatchers("/registeruser**").hasRole("ADMIN")
		.antMatchers("/createvisit**").permitAll()
		.antMatchers("/managevisit**").permitAll()
		.antMatchers("/editvisit**").permitAll()
		.antMatchers("/**").permitAll()*/
		.and()
		.formLogin().loginPage("/login")
		.defaultSuccessUrl( "/homepage" )
		//Handling Logout
		.and()
		.logout().logoutSuccessUrl("/hms"); 
		http.csrf().disable();

	}
}
