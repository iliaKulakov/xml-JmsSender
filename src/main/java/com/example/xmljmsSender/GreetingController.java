package com.example.xmljmsSender;

import com.example.xmljmsSender.jms.Message;
import com.example.xmljmsSender.jms.Sender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class GreetingController {

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String,Object> model) {
////        model.put("name", name);
//        return "greeting";
//    }

    @RequestMapping(value="/greeting", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);

        Message.setMessage(greeting.getContent());


//        Greeting greeting1 = new Greeting();
//        greeting1.getListContent().add(greeting.getContent());
//
//
//
//        Sender sender = new Sender();
//
//        for(String lines: greeting1.getListContent()){
//            System.out.println("My messages in list: " + lines);
//            sender.send(lines);
//        }


        return "result";
    }

}
