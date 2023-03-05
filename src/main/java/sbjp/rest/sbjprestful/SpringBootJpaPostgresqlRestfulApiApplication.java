package sbjp.rest.sbjprestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import sbjp.rest.sbjprestful.entities.User;
import sbjp.rest.sbjprestful.enums.RoleEnum;
import sbjp.rest.sbjprestful.repositories.IUserRepository;

//@EnableJpaRepositories(basePackages = {"sbjp.rest.sbjprestful.repositories"})

@SpringBootApplication
public class SpringBootJpaPostgresqlRestfulApiApplication implements CommandLineRunner {
	@Autowired
	IUserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	// @Autowired
	// private AccountsRepository ac;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaPostgresqlRestfulApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Khi chương trình chạy
         //Insert vào csdl một user.
//        User user = new User();
//        user.setUserName("dia");
//        user.setPassword(passwordEncoder.encode("dia"));
//        user.setRole(RoleEnum.ROLE_USER.getRoleValue());
//        System.out.println(user.toString()+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        userRepository.save(user);
//        System.out.println(user.toString()+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	// @Override
	// public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	// List<Account> ls=ac.findAll();
	// ls.forEach(System.out::println);
	// }
	/*
	 * @Bean public Docket productApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).select()
	 * .apis(RequestHandlerSelectors.basePackage("sbjp.rest.sbjprestful.controller")
	 * ).build(); }
	 */
}
