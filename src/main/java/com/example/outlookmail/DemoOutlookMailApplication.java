package com.example.outlookmail;

import com.example.outlookmail.utils.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoOutlookMailApplication {

    public static void main(String[] args) throws FileNotFoundException {

        SpringApplication.run(DemoOutlookMailApplication.class, args);
        Email email = new Email();
        String templateFilePath = "/home/beehyv/Beesheets-Templates/demo OutlookMail/src/main/webapp/views/managerTemplate.jsp";
        String html= new BufferedReader(new FileReader(templateFilePath)).lines().collect(Collectors.joining("\n"));
        ArrayList<String> list = new ArrayList<>();
        email.send("Check",html,"vishnu.p@beehyv.com",list);

    }

}
