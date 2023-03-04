package sbjp.rest.sbjprestful.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {
	
	/*
	 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
	 * .select()
	 * .apis(RequestHandlerSelectors.basePackage("sbjp.rest.sbjprestful.controller")
	 * ) .paths(PathSelectors.any()) .build() .pathMapping("/api"); }
	 */
	/*
	 * @Bean Docket api() { return new Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any()) .build()
	 * .apiInfo(apiInfo()) .pathMapping("/"); }
	 */

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper;
	}
	
	/*
	 * private ApiInfo apiInfo() { return new ApiInfoBuilder()
	 * .title("Rent For House API") .build(); }
	 */
}
