package com.example.xmljmsSender;

import com.example.xmljmsSender.jms.MessageToQueue;
import com.example.xmljmsSender.jms.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String,Object> model) {
////        model.put("name", name);
//        return "greeting";
//    }

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
        model.addAttribute("greeting", greeting);

        messageToQueue.setMessage(greeting.getContent());


        sender.send(greeting.getContent());

        return "result";
    }

}
