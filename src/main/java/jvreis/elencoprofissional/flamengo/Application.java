package jvreis.elencoprofissional.flamengo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jvreis.elencoprofissional.flamengo.services.ScrapingConfiguration;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		new ScrapingConfiguration();
	}

}
