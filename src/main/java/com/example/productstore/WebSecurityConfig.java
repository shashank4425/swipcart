package com.example.productstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration

public class WebSecurityConfig {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		 http.authorizeRequests()
//	        .antMatchers("/user-auth")
//	            .permitAll()
//	        .antMatchers("/**")
//	            .hasAnyRole("ADMIN", "USER")
//	        .and()
//	            .formLogin()
//	            .loginPage("/user-auth")
//	            .defaultSuccessUrl("/")
//	            .failureUrl("/user-auth?error=true")
//	            .permitAll()
//	        .and()
//	            .logout()
//	            .logoutSuccessUrl("/user-auth?logout=true")
//	            .invalidateHttpSession(true)
//	            .permitAll()
//	        .and()
//	            .csrf()
//	            .disable();
//	    
//		
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	  @Autowired
//	  private UserDetailsService UserDetailsService;
//      @Bean   
//       public AuthenticationProvider AuthenticationProvider() {
//    	 DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//    	 provider.setUserDetailsService(UserDetailsService);
//	    return provider;
//	
//     }
	
	
}
