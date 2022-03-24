package com.example.sql_til_html.Controller;


import com.example.sql_til_html.model.userInfo;
import com.example.sql_til_html.respository.EmailRepository;
import com.example.sql_til_html.services.SQLFunctions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Controller
public class EmailController {
    private final EmailRepository showAllUsers = new EmailRepository();


    @GetMapping("/AcceptetMails")
    public String acceptetMails(Model thingThatTransportDataToView) throws SQLException {

        Connection test = SQLFunctions.connectDB();
        List<userInfo> allUserInfos = SQLFunctions.returnUsers();
        thingThatTransportDataToView.addAttribute("test", allUserInfos);
        return "AcceptetMails";
    }

    @PostMapping("/session")
    public String mySession(HttpSession session, Model model){
    String helloworld = (String) session.getAttribute("mail");
    model.addAttribute("message",helloworld);
        return "session";
    }

    @PostMapping("/sessionReal")
    public String realSession(HttpSession session){
        session.setAttribute("mail","Hello world");
        return "redirect:/";
    }
}
