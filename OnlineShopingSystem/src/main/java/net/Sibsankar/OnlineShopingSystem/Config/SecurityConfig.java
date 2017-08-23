/*package net.Sibsankar.OnlineShopingSystem.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Bean("passwordEncoder")
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/manage/**").access("hasAuthority('ADMIN')")
		.antMatchers("/cart/**").access("hasAuthority('USER')")
		.antMatchers("/**").access("permitAll")
		.and()
		.formLogin().loginPage("/login")
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")
		.and()
		.exceptionHandling().accessDeniedPage("/acsess_reject");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().passwordEncoder(passwordEncoder()).dataSource(dataSource)
				.usersByUsernameQuery("select email,password,enabled from user_detail where email=?")
				.authoritiesByUsernameQuery("select email,role from user_detail where email=?");
	}
}*/
