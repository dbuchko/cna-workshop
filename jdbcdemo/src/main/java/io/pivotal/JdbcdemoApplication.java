package io.pivotal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JdbcdemoApplication {

	@Value("${username}")
	private String username;

	@Value("${password}")
	private String password;

	public static void main(String[] args) {
		SpringApplication.run(JdbcdemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder().basicAuthorization(username, password).build();
	}

}
