package com.pratsan.kirana;

import com.pratsan.kirana.dto.ResponseDto;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication
@Configuration
//@EnableSwagger2
@SwaggerDefinition
public class KiranaApplication {
@Bean
	SimpleMailMessage simpleMailMessage()
{
	return new SimpleMailMessage();
}
	@Bean
	ResponseDto<?> responseDto()
{
	return  new ResponseDto();
}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(KiranaApplication.class, args);
	}

}
