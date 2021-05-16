package com.example.productstore;

import java.io.InputStream;
import java.util.List;

import org.hibernate.annotations.Loader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication

public class ProductStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductStoreApplication.class, args);
		
		
		
	}

}
