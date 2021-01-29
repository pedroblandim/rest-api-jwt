package com.rest.api.security;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			.cors().and()
			.csrf().disable();
		
	}
	
	
//    private static final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(
//		new AntPathRequestMatcher("/public/**")
//    );
//    private static final RequestMatcher PROTECTED_URLS = new NegatedRequestMatcher(PUBLIC_URLS);
//    
//    private TokenAuthenticationProvider provider;
//	
//	SecurityConfig(final TokenAuthenticationProvider provider) {
//		super();
//		this.provider = provider;
//	}
//
//
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		// Build the authenticationManager to be used in this class from a AuthenticationProvider
//		// Call this.authenticationManager() to retrieve it
//		auth.authenticationProvider(provider);
//	}
//	
//	@Override
//	public void configure(final WebSecurity web) throws Exception {
//		web.ignoring().requestMatchers(PUBLIC_URLS);
//	}
//
//
//	@Override
//	protected void configure(final HttpSecurity http) throws Exception {
//		http
//			.sessionManagement()
//			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//			.and()
//			.exceptionHandling()
//			// this entry point handles when you request a protected page and you are not yet
//			// authenticated
//			.defaultAuthenticationEntryPointFor(forbiddenEntryPoint(), PROTECTED_URLS)
//			.and()
//			//.authenticationProvider(provider)
//			.addFilterBefore(restAuthenticationFilter(), AnonymousAuthenticationFilter.class)
//			.authorizeRequests()
//			.requestMatchers(PROTECTED_URLS)
//			.authenticated()
//			.and()
//			.csrf().disable()
//			.formLogin().disable()
//			.httpBasic().disable()
//			.logout().disable();
//	}
//		
//	@Bean
//	TokenAuthenticationFilter restAuthenticationFilter() throws Exception {
//		// This basically connects the filter to the AuthenticationProvider (TokenAuthenticationProvider)
//		// and sets the authenticationSuccessHandler
//		final TokenAuthenticationFilter filter = new TokenAuthenticationFilter(PROTECTED_URLS);
//		filter.setAuthenticationManager(authenticationManager());
//		filter.setAuthenticationSuccessHandler(successHandler());
//		return filter;
//	}
//	
//	@Bean
//	SimpleUrlAuthenticationSuccessHandler successHandler() {
//		final SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
//		successHandler.setRedirectStrategy(new NoRedirectStrategy());
//		return successHandler;
//	}
//	
//	/**
//	* Disable Spring boot automatic filter registration.
//	*/
//	@Bean
//	FilterRegistrationBean disableAutoRegistration(final TokenAuthenticationFilter filter) {
//		final FilterRegistrationBean registration = new FilterRegistrationBean(filter);
//		registration.setEnabled(false);
//	    return registration;
//	}
//	
//	@Bean
//	AuthenticationEntryPoint forbiddenEntryPoint() {
//		return new HttpStatusEntryPoint(HttpStatus.FORBIDDEN);
//	}
}
