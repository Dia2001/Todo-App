package sbjp.rest.sbjprestful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableJpaRepositories(basePackages = {"sbjp.rest.sbjprestful.repositories"})

@SpringBootApplication
public class SpringBootJpaPostgresqlRestfulApiApplication  {
	
	//@Autowired
	//private AccountsRepository ac;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaPostgresqlRestfulApiApplication.class, args);
	}

	//@Override
	//public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//List<Account> ls=ac.findAll();
		//ls.forEach(System.out::println);
	//}
	/*
	 * @Bean public Docket productApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).select()
	 * .apis(RequestHandlerSelectors.basePackage("sbjp.rest.sbjprestful.controller")
	 * ).build(); }
	 */
}
