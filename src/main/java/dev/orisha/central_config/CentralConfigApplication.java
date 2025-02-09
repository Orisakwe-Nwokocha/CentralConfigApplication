package dev.orisha.central_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CentralConfigApplication {

	public static void main(String[] args) {
//		System.setProperty("spring.devtools.restart.enabled", "true");
		SpringApplication.run(CentralConfigApplication.class, args);
	}

}
