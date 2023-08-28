package com.test.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors(withDefaults())
                .authorizeHttpRequests()
                .antMatchers("/empresa/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .httpBasic(withDefaults());
	}
	
	@Bean
	protected PasswordEncoder encoder() {
		return  new BCryptPasswordEncoder();
	}

	@Bean
	protected InMemoryUserDetailsManager userDetailsManager() {
		UserDetails userDetailsAdmin=User.builder()
				.username("admin")
				.password(encoder().encode("Example2023Admin"))
				.roles("ADMIN")
				.build();
		UserDetails userDetailsUser=User.builder()
				.username("user")
				.password(encoder().encode("Example2023User"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(userDetailsAdmin,userDetailsUser);
	}
}
