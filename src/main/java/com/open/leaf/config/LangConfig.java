package com.open.leaf.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.open.leaf")
public class LangConfig implements WebMvcConfigurer{
	
	 String[] basenames = {
		                   "lang/index/messages_index",
		                   "lang/login/messages_login",
		                   "lang/signup/messages_signup"
		                  };	
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames(basenames);
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setFallbackToSystemLocale(false);
	    return messageSource;
	}
	
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.ENGLISH);
	    return slr;
	}

	@Bean	
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
	    interceptor.setParamName("lang"); 
	    return interceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(localeChangeInterceptor());
	}



}
