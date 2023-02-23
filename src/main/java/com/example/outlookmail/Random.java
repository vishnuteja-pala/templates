package com.example.outlookmail;


import com.example.outlookmail.utils.Email;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Random implements Runnable{

    @Override
    public void run(){
        Email email = new Email();
        String html="<h1>Hello</h1>";
        ArrayList<String> list = new ArrayList<>();
        email.send("Check",html,"vishnu.p@beehyv.com",list);
    }
}