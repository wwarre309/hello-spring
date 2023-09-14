package org.launchcode.hellospring.controllers;

//import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloSpringController {
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})

    public String hello(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    @GetMapping("hello/{name}")

    public String helloAgain(@PathVariable String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScripts");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
