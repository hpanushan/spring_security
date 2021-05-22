package com.globalwavenet.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

@EnableSwagger2
@Configuration
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration(){
        // Return a prepared docket instance
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.globalwavenet.spring_security"))
                .build()
                .apiInfo(apiDetails())
                .securitySchemes(Collections.singletonList(apiKey()));
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "API",
                "",
                "1.0V",
                "",
                new springfox.documentation.service.Contact("","",""),
                "",
                "",
                Collections.emptyList());
    }

    @Bean
    public SecurityScheme apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }


}
