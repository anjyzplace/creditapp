package com.creditapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Anjola on 04/08/2017.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    @Value("${swagger.enabled:false}")
//    private boolean swaggerEnabled;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(swaggerEnabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.creditapp.Controller"))
                .paths(regex("/application.*"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        return new ApiInfo(
                "Credit Application API",
                "The API for Credit Application",
                "1.0",
                "Terms of service",
                "Anjola Awofisoye",
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
    }
}
