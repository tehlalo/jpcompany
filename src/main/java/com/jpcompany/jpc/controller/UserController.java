package com.jpcompany.jpc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.jpcompany.jpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jpcompany.jpc.model.User;
import com.jpcompany.jpc.model.Role;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home()
    {
        //test
        return "index.html";
        //return "home.jsp";

    }

    @RequestMapping("/login")
    public String loginPage()
    {
        return "login.html";

    }
    
    @RestController
    public class IndexController implements ErrorController{

        @RequestMapping("/error")
        @ResponseBody
        public String handleError(HttpServletRequest request) {
        	Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
            Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
            return String.format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
                            + "<div>Exception Message: <b>%s</b></div><body></html>",
                    statusCode, exception==null? "N/A": exception.getMessage());
        	
        	//return "Error handling";
        }

        @Override
        public String getErrorPath() {
        	return "/error";
        }
    }
    

    /*
    @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();

        model.setViewName("login.html");
        return model;
    }
    */
    
    

//    @RequestMapping(value= {"/register"}, method=RequestMethod.GET)
//    public ModelAndView signup() {
//        ModelAndView model = new ModelAndView();
//        User user = new User();
//        model.addObject("user", user);
//        model.setViewName("register.html");
//
//        return model;
//    }

    @RequestMapping(value= {"/register"}, method=RequestMethod.GET)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("register.html?success=false");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            model.setViewName("register.html?success=true");
        }

        return model;
    }

/*
    @RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        model.addObject("userName", user.getFirstname() + " " + user.getLastname());
        model.setViewName("home/home");
        return model;
    }
*/
    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }
}