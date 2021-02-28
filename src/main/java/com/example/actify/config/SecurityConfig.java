package com.example.actify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	//creating a password encoder to make it more secure
    	PasswordEncoder encoder = 
          PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	auth
    	//using inMemoryAuthentication for security since storing in table doesn't make sense
          .inMemoryAuthentication()
          .withUser("developer")
          .password(encoder.encode("password"))
          .roles("DEVELOPER")
          .and()
          .withUser("admin")
          .password(encoder.encode("password"))
          .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
          .httpBasic()
          .and()
            .authorizeRequests()
            .antMatchers("/","/login")
				.permitAll()
            .antMatchers("/listAllEmployees")
			  .hasAnyRole("ADMIN")
		    .antMatchers("/getEmployeeData/**")
			  .hasAnyRole("DEVELOPER")
			.antMatchers("/**")
			  .authenticated()
		  .and()
			.formLogin()
			.defaultSuccessUrl("/")
			.permitAll()
		  .and()
			.logout()
			.logoutSuccessUrl("/")
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.invalidateHttpSession(true)
			.permitAll();
    }
}