package com.am.hambuqueria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Hamburqueria"), servers = {
		@Server(url = "http://localhost:8081")
})
@EnableCaching
public class HambuqueriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HambuqueriaApplication.class, args);
	}

}
