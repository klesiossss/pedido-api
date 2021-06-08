package br.com.bluesoft.desafio.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	       .apis(RequestHandlerSelectors.basePackage("br.com.bluesoft.desafio.controller"))
	        .paths(PathSelectors.any())
	        .build()
	        .useDefaultResponseMessages(false)
	        .apiInfo(apiInfo())
	        ;
	}
    
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "PEDIDO-DESAFIO API", 
	      "Esta API consiste em retornar uma lista de pedidos "
	      + "associado a cada fornecedor que oferece produtos mais em conta.", 
	      "API", 
	      "Terms of service", 
	      new Contact("Klesio Silva", "https://github.com/klesiossss", "klesiossss@gmail.com"), 
	      "https://www.linkedin.com/in/klesio-silva-e-silva-87987717b/", "https://github.com/klesiossss", Collections.emptyList());
	}
    
    private List<ResponseMessage> responseMessageForGET()
    {
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                .code(500)
                .message("500 message")
                .responseModel(new ModelRef("Error"))
                .build());
            add(new ResponseMessageBuilder()
                .code(403)
                .message("Forbidden!")
                .build());
            add(new ResponseMessageBuilder()
                    .code(200)
                    .message("Ok!")
                    .build());
            add(new ResponseMessageBuilder()
                    .code(201)
                    .message("Criado!")
                    .build());
            add(new ResponseMessageBuilder()
                    .code(400)
                    .message("Bad Request!")
                    .build());
            add(new ResponseMessageBuilder()
                    .code(404)
                    .message("Not Found!")
                    .build());
        }};
    }
}