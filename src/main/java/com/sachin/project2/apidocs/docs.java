package com.sachin.project2.apidocs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class docs {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.sachin.project2")).build();
    }

//    private Predicate<String> postPaths() {
//        return regex("/");
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("COB API")
                .description("API reference for developers")
                .termsOfServiceUrl("http://localhost:8000")
                .license("License")
                .version("1.0").build();
    }
}
