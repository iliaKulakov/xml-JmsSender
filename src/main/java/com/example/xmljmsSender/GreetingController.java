package com.example.xmljmsSender;

import com.example.xmljmsSender.jms.MessageToQueue;
import com.example.xmljmsSender.jms.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.example.xmljmsSender.XmlJmsSenderApplication.userLogger;

@Controller
public class GreetingController {

    @Autowired
    MessageToQueue messageToQueue;

    @Autowired
    Sender sender;

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {


        try {
            model.addAttribute("greeting", greeting);

            messageToQueue.setMessage(greeting.getContent());
            sender.sendStringMsg(greeting.getContent());
        } catch (Exception ex) {
            userLogger.error("error message: " + ex.getMessage());
            userLogger.fatal("fatal error message: " + ex.getMessage());
        }







        return "result";
    }

}
