package sber.test.p1.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author UserAdmin
 */
@Controller
public class IndexController {
    
    @GetMapping("/")
    public String getIndexPage(ModelMap model, HttpServletRequest request, Authentication authentication) {
        System.out.println("IndexController.getIndexPage()");
        
        if(authentication==null) {
            return "redirect:/login";
        }
        
        User u = (User)authentication.getPrincipal();
        System.out.println("User: "+u.getUsername());

        model.addAttribute("username", u.getUsername());
        //return "index";
        return "chat";
    }
    
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        System.out.println("IndexController.logout()");
        request.getSession(true).invalidate();
        return "redirect:/login";
    }
}
