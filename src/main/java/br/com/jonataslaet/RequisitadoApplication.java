package br.com.jonataslaet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.jonataslaet.config.RequisitadoApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(RequisitadoApiProperty.class)
public class RequisitadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequisitadoApplication.class, args);
	}

}
