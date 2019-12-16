package com.jpcompany.jpc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @GetMapping("/blank")
    public String blank() {
        return "blank";
    }
    
    @GetMapping("/userReg")
    public String userReg() {
        return "userReg";
    }
    
    @GetMapping("/activeOrders")
    public String activeOrders() {
        return "activeOrders";
    }
    
    @GetMapping("/canceledOrders")
    public String canceledOrders() {
        return "canceledOrders";
    }
    
    @GetMapping("/completedOrders")
    public String completedOrders() {
        return "completedOrders";
    }
    
    @GetMapping("/editUser")
    public String editUser() {
        return "editUser";
    }
    
    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "forgotPassword";
    }
    
    @GetMapping("/pendingApprovals")
    public String pendingApprovals() {
        return "pendingApprovals";
    }
    
    @GetMapping("/myAccount")
    public String myAccount() {
        return "myAccount";
    }
    
}
