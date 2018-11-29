package com.prit.playground.hystrix.circuitbreaker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * The class {@code SwaggerConfig} is the responsible for the configuration of SWAGGER beans to show the
 * documentation on swagger UI. It uses "Spring fox Web Mvc Configuration"
 *
 * @author Pritesh Malviya
 */
@SuppressWarnings("unused")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @SuppressWarnings("unused")
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
                .build();
    }
}