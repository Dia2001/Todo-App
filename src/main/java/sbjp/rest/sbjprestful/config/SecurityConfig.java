package sbjp.rest.sbjprestful.config;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import sbjp.rest.sbjprestful.config.jwt.JwtAuthTokenFilter;


//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableMethodSecurity
@Configuration
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class SecurityConfig  {
	
	@Autowired
	UserDetailsService userService;

	@Bean
	public JwtAuthTokenFilter jwtAuthenticationFilter() {
		return new JwtAuthTokenFilter();
	}

//	@Autowired
//	private EndPointFilterConfig enpoint;
//
//	@Autowired
//	private RequestFilterConfig filter;
//	private AuthenticationProvider authenticationProvider;
//
//	private LogoutHandler logoutHandler = (HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) -> {
//
//	};
//
//	private static final String[] AUTH_WHITELIST = {
//			// -- Swagger UI v2
//			"/v2/api-docs", "v2/api-docs", "/swagger-resources", "swagger-resources", "/swagger-resources/**",
//			"swagger-resources/**", "/configuration/ui", "configuration/ui", "/configuration/security",
//			"configuration/security", "/swagger-ui.html", "swagger-ui.html", "webjars/**",
//			// -- Swagger UI v3
//			"/v3/api-docs/**", "v3/api-docs/**", "/swagger-ui/**", "swagger-ui/**",
//			// CSA Controllers
//			"/csa/api/token",
//			// Actuators
//			"/actuator/**", "/health/**" };
//
//	/*
//	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
//	 * throws Exception { return http.csrf(AbstractHttpConfigurer::disable)
//	 * .authorizeHttpRequests( auth ->
//	 * auth.requestMatchers(AUTH_WHITELIST).permitAll().anyRequest().authenticated()
//	 * ) .sessionManagement(session ->
//	 * session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//	 * .httpBasic(withDefaults()) .addFilterBefore(filter,
//	 * UsernamePasswordAuthenticationFilter.class) //
//	 * .addFilterAfter(authenticationJwtTokenFilter, //
//	 * UsernamePasswordAuthenticationFilter.class) .build(); }
//	 */
//
//	/*
//	 * @Bean public SecurityFilterChain configure(HttpSecurity httpSecurity) throws
//	 * Exception { httpSecurity.authorizeHttpRequests((requests) -> requests
//	 * .requestMatchers(HttpMethod.POST, "/api/customers/**").permitAll()
//	 * .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
//	 * .requestMatchers(new AntPathRequestMatcher("v3/api-docs/**")).permitAll()
//	 * .requestMatchers(new
//	 * AntPathRequestMatcher("/v3/api-docs/**")).permitAll().anyRequest().
//	 * authenticated()) .httpBasic(); return httpSecurity.build(); }
//	 */
////
////	@Bean
////	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////		http.csrf().disable().authorizeHttpRequests().requestMatchers("/api/v1/auth/**").permitAll().anyRequest()
////		.requestMatchers("/user/**")
////	      .hasAnyRole("USER", "ADMIN")
////				.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
////				.authenticationProvider(authenticationProvider)
////				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
////
////		return http.build();
////	}
//	@Bean
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
		.requestMatchers("/api/v1/auth/login").permitAll()
		.requestMatchers(HttpMethod.POST,"/api/v1/users").permitAll()
		.requestMatchers(HttpMethod.GET,"/api/v1/users").hasRole("ADMIN")
		.requestMatchers(HttpMethod.DELETE,"/api/v1/users/{userId}").hasRole("ADMIN")
		.requestMatchers(HttpMethod.PUT,"/api/v1/users/{userId}").hasRole("USER")
				//.requestMatchers("/**").hasAnyRole("USER", "ADMIN")
				.anyRequest().authenticated().and()
				.authenticationProvider(authenticationProvider())
				.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.httpBasic(withDefaults()).sessionManagement().sessionCreationPolicy(STATELESS);
		return http.build();
	}


	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		// TODO Auto-generated method stub
////		http.cors();
////		http.csrf().disable();
////		http.authorizeRequests().antMatchers("/api/login").permitAll().and()
////			.authorizeRequests()
////			.antMatchers(HttpMethod.POST, "/api/customers/**").access("hasRole('ROLE_EDIT')")
////			.antMatchers(HttpMethod.PUT, "/api/customers/**").access("hasRole('ROLE_EDIT')")
////			.antMatchers(HttpMethod.DELETE, "/api/customers/**").access("hasRole('ROLE_DELETE')")
////				
////			.anyRequest().authenticated().and().exceptionHandling()
////			.authenticationEntryPoint(enpoint).and().sessionManagement()
////			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////		
////		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
////	}

	// @Bean(BeanIds.AUTHENTICATION_MANAGER)
	// @Override
	// public AuthenticationManager authenticationManagerBean() throws Exception {
	// Get AuthenticationManager bean
	// return super.authenticationManagerBean();
	// }

	@Bean
	public PasswordEncoder passwordEncoder() {
		// Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
		return new BCryptPasswordEncoder();
	}

	// @Override
	// protected void configure(AuthenticationManagerBuilder auth)
	// throws Exception {
	// auth.userDetailsService(userService) // Cung cáp userservice cho spring
	// security
	// .passwordEncoder(passwordEncoder()); // cung cấp password encoder
	// }

//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http
//	                .cors() // Ngăn chặn request từ một domain khác
//	                    .and()
//	                .authorizeRequests()
//	                    .antMatchers("/api/login").permitAll() // Cho phép tất cả mọi người truy cập vào địa chỉ này
//	                    .anyRequest().authenticated(); // Tất cả các request khác đều cần phải xác thực mới được truy cập
//
//	        // Thêm một lớp Filter kiểm tra jwt
//	        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//	    }
}
