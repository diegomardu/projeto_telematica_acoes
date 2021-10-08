package com.projeto.telematica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class AcoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcoesApplication.class, args);
	}

	@Bean
	public FixedLocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

}
