package com.example.sql_til_html.Controller;

import com.example.sql_til_html.services.CheckMail;
import com.example.sql_til_html.services.SQLFunctions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class main {

    @GetMapping("/")
    public String Homepage() {
        return "index";
    }


    @GetMapping("/CheckMail")
    public String CheckMail(){
        SQLFunctions.connectDB();

        return "CheckMail";
    }

    @PostMapping("/Get-Info")
    public String getInfo(WebRequest dataFromForm){
        String userName = (dataFromForm.getParameter("fName"));
        String userMail = (dataFromForm.getParameter("Mail"));

        if(CheckMail.checkIfMail(userMail) == true){
            SQLFunctions.addToTable(userName,userMail);
            return "redirect:/";}
        else{ return "redirect:/WrongMail";}
    }


    @GetMapping("/WrongMail")
    public String wrongMail(){


        return "WrongMail";
    }
}
