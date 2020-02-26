package com.arasu.vacancy.swagger;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Path;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfigProperties {

	private static final String DEFAULT_INCLUDE_PATTERN = "/.*";
	@Value("${swagger.title}")
	private String title;

	@Value("${security.header}")
	private String header;
	
	@Value("${swagger.description}")
	private String description;
	
	@Value("${swagger.version}")
	private String version;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.securityContexts(Lists.newArrayList(securityContext()))
					.securitySchemes(Lists.newArrayList(apiKey()))
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.arasu.vacancy"))
					.paths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
					.build().apiInfo(apiInformation());
	}
	
	private ApiInfo apiInformation() {
		return new ApiInfoBuilder().title(title)
				.description(description)
				.version(version)
				.build();
	}
	private ApiKey apiKey() {
		return new ApiKey("JWT", header, "header");
	}
	private SecurityContext securityContext() {
		return SecurityContext.builder()
				.securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
				.build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes= new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
	}
}
