package com.example.xmljmsSender;


import com.example.xmljmsSender.jms.MessageToQueue;
import com.example.xmljmsSender.jms.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class XmlJmsSenderApplication
//        implements ApplicationRunner
        extends SpringBootServletInitializer implements ApplicationRunner {

	@Autowired
	Sender sender;

	@Autowired
	MessageToQueue messageToQueue;

	public static void main(String[] args) {
		SpringApplication.run(XmlJmsSenderApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {

	}


}
