package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootThymeleafCrudWebAppApplication {
	// spustame metodu main, ktora si hlada @GetMapping("/") - ten sa nachadza v classe, kde je anotacia @Controller
	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeleafCrudWebAppApplication.class, args);
	}
}
