package br.edu.unoesc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "br.edu.unoesc.controller" })
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
	
	
	// implements WebMvcConfigurer 
	
}