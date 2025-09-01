package br.com.phamtecnologia.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API - Sistema de contatos")
						.description("Documentação da API do sistema desenvolvido em Spring Boot")
						.version("1.0.0")
						.contact(new Contact()
								.name("Pedro Maranhão")
								.url("https://www.linkedin.com/in/pedro-henrique-alves-maranhao/")
								.email("pedro.maranhao@yahoo.com.br"))
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation()
						.description("Mais informações")
						.url("https://github.com.br/cotiinformatica"));
	}

}
