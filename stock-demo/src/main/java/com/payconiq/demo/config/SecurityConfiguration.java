package com.payconiq.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The Class SecurityConfiguration.
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// Below method can be used if security is needed before moving app to PR also
	// modifying code statement in next function
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.inMemoryAuthentication()
	 * .withUser("HBK").password("{noop}test").roles("USER").and()
	 * .withUser("ANU").password("{noop}test").roles("ADMIN"); }
	 */

	/**
	 * protected void configure(HttpSecurity httpSecurity) throws Exception.
	 *
	 * @param httpSecurity
	 *            the http security
	 * @throws Exception
	 *             the exception
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
				// .antMatchers("/api/*").hasRole("ADMIN")
				.anyRequest()
				// .fullyAuthenticated()
				.permitAll().and().httpBasic();
		httpSecurity.csrf().disable();
	}

}
