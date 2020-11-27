package com.ltapp.latestApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@ComponentScan()
public class LatestApp {
	@Autowired
	private static NewsService service;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(LatestApp.class, args);
		NewsService s = (NewsService) ctx.getBeanFactory().getBean(NewsService.class);
		s.createNews();
	}
}
