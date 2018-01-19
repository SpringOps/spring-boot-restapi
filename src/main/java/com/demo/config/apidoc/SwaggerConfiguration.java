package com.demo.config.apidoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.StopWatch;

import com.demo.config.Constants;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Springfox Swagger configuration.
 *
 * Warning! When having a lot of REST endpoints, Springfox can become a performance issue. In that
 * case, you can use a specific Spring profile for this class, so that only front-end developers
 * have access to the Swagger view.
 */
@Configuration
@EnableSwagger2
@Profile(Constants.SPRING_PROFILE_SWAGGER)
public class SwaggerConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfiguration.class);

    public static final String DEFAULT_INCLUDE_PATTERN = "/api";

    /**
     * Swagger Springfox configuration.
     *
     * @param jHipsterProperties the properties of the application
     * @return the Swagger Springfox configuration
     */
    @Bean
    public Docket swaggerSpringfoxDocket() {
    	LOGGER.debug("Starting Swagger");
        StopWatch watch = new StopWatch();
        watch.start();
        Contact contact = new Contact(
            "Test User",
            "Test",
            "test@abc.com");

        ApiInfo apiInfo = new ApiInfo(
            "My App",
             "",
            "0.1",
            "",
            contact,
            "",
           "");

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
        		.select()
        	      .apis(RequestHandlerSelectors.basePackage("com.demo.web.rest"))
        	      .paths(PathSelectors.ant("/api/*"))
        	      .build()
        	      .apiInfo(apiInfo);
        watch.stop();
        LOGGER.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
        return docket;
    }
}
