package org.asifanam.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
public class TestCatalogServiceApplication {
//	@Bean
//	@ServiceConnection
//	PostgreSQLContainer<?> postgresContainer() {
//		return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine"));
////		SpringApplication
//	}
	public static void main(String[] args) {
		SpringApplication
				.from(CatalogServiceApplication::main)
				.with(TestcontainersConfiguration.class)
				.run(args);
	}

}
