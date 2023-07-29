package com.frank.flowabledemo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.frank.flowabledemo.config.MyApolloProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@Slf4j
@ConfigurationPropertiesScan
public class FlowableDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FlowableDemoApplication.class, args);
	}

	@Autowired
	private MyApolloProperties myApolloProperties;
	@Override
	public void run(String... args) throws Exception {
		Executors.newFixedThreadPool(1).submit(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					log.error("error", e);
				}
				log.info("myApolloProperties: {}", myApolloProperties.getUsCidr());
			}
		});
	}
}
