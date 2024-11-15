package com.example.social_media_app_gateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {OAuth2ResourceServerAutoConfiguration.class,
		ReactiveOAuth2ResourceServerAutoConfiguration.class})
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "GATEWAY API", version = "1.0"),
		servers = {@Server(url = "/", description = "Default Server URL")},
		security = {@SecurityRequirement(name = "Authorization")})
public class SocialMediaAppGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(SocialMediaAppGatewayApplication.class, args);
	}
}
