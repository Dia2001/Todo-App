package sbjp.rest.sbjprestful.config;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sbjp.rest.sbjprestful.config.jwt.JwtAuthTokenFilter;
import sbjp.rest.sbjprestful.config.jwt.JwtBlacklist;
import sbjp.rest.sbjprestful.config.jwt.JwtProvider;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	UserDetailsService userService;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	private JwtBlacklist jwtBlacklist;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().requestMatchers("/api/v1/auth/login").permitAll()
				.requestMatchers(HttpMethod.POST, "/api/v1/users").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/v1/users").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/api/v1/users/{userId}").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/api/v1/users/{userId}").hasRole("USER")
				// .requestMatchers("/**").hasAnyRole("USER", "ADMIN")
				.anyRequest().authenticated().and().authenticationProvider(authenticationProvider())
				.addFilterBefore(new JwtAuthTokenFilter(jwtBlacklist, jwtProvider, userService),
						UsernamePasswordAuthenticationFilter.class)
				.logout().logoutUrl("/api/v1/auth/logout").logoutSuccessHandler(new LogoutSuccessHandler() {
					@Override
					public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						String token = request.getHeader("Authorization");
						if (token != null && token.startsWith("Bearer ")) {
							token = token.substring(7);
							jwtBlacklist.addToBlacklist(token);
						}
						response.setStatus(HttpStatus.OK.value());
					}
				}).and().httpBasic(withDefaults()).sessionManagement().sessionCreationPolicy(STATELESS);

		return http.build();
	}

	@Scheduled(fixedDelay = 3600000) // Run every hour
	public void removeExpiredTokens() {
		jwtBlacklist.removeExpiredTokens();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
