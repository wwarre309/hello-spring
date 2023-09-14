package org.launchcode.hellospring.controllers;

import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@ResponseBody
@RequestMapping ("hello")
public class HelloController {
    //path at hello
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    //path at hello/goodbye
    @GetMapping ("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //requests of form at hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam (@RequestParam String name) {
//        return "Hello," + name + "!";
//    }

    @RequestMapping (value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language){
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";
        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }
        return greeting + " " + n;
    }

    //requests of form at hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello," + name + "!";
//    }

    //requests for hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "form action= '/hello' method = 'post'>" +
                "<input type = 'text' name = 'name'>" +
                "<input type = 'submit' value = 'Greet Me!'>" +
                ",/form>" +
                "</body>" +
                "</html>";
    }



}
