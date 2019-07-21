package com.example.xmljmsSender;

import com.example.xmljmsSender.jms.Message;
import com.example.xmljmsSender.jms.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class XmlJmsSenderApplication implements ApplicationRunner {

	@Autowired
	Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(XmlJmsSenderApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		String test = Message.getMessage();
		sender.send(test);
	}


}
