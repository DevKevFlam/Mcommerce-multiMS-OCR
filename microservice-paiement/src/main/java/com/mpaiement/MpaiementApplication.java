package com.mpaiement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.mpaiement")
@EnableDiscoveryClient
@EnableConfigurationProperties
public class MpaiementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpaiementApplication.class, args);
	}

}
