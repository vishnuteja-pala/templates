package com.example.outlookmail.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind. annotation.RequestMapping;
@Controller
public class  templateController{
    @RequestMapping("/managerTemplate")
    public String home() {

        return "managerTemplate";
    }

}