package com.carontime.on_time.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CarOnTimeControler {

    @GetMapping("/")
    public String start() {
        return "layout";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String user() {
        return "userData";
    }

    @GetMapping("/admin")
    public String admin() {
        return "adminData";
    }



}
