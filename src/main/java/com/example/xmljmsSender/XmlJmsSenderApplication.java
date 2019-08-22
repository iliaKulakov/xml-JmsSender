package com.example.xmljmsSender;


import com.example.xmljmsSender.jms.MessageToQueue;
import com.example.xmljmsSender.jms.Sender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
public class XmlJmsSenderApplication implements ApplicationRunner {

    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier(){

                    public boolean verify(String hostname,
                                          javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals("localhost")) {
                            return true;
                        }
                        return false;
                    }
                });
    }

    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger userLogger = LogManager.getLogger(GreetingController.class);

    @Autowired
    Sender sender;

    @Autowired
    MessageToQueue messageToQueue;


    public static void main(String[] args) {


        try {
            SpringApplication.run(XmlJmsSenderApplication.class, args);
        } catch (Exception ex) {
            userLogger.error("error message: " + ex.getMessage());
            userLogger.fatal("fatal error message: " + ex.getMessage());
        }

    }

    @Override
    public void run(ApplicationArguments args) {
		sender.sendStringMsg("Hello");
    }


}
