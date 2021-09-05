package br.ifpe.web2.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.ifpe.web2.model.AutorizadorInterceptor;

@Configuration
public class Config implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//qual tipo de servico q adiciona a esse interceptador .addpattern o que é .addPathPatterns(null)
		//xml é mais antigo
		registry.addInterceptor(new AutorizadorInterceptor());
	}
}
