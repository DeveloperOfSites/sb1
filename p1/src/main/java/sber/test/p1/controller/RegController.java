
package sber.test.p1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sber.test.p1.model.RegUser;

/**
 *
 * @author UserAdmin
 */
@Controller
public class RegController {
    
    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    
    @GetMapping(value = "/reg")
    public String getRegPage(ModelMap model, HttpServletRequest request) {
        System.out.println("RegController.getRegPage");
        model.addAttribute("userForm",new RegUser("1","2","3","4"));
        return "reg";
    }
    
    @PostMapping("/reg")
    public String postRegPage(@ModelAttribute("userForm") @Valid RegUser userForm, BindingResult bindingResult, Model model) {
        System.out.println("RegController.postRegPage");
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        
        System.out.println("userForm "+userForm);
        User.UserBuilder user = User.withDefaultPasswordEncoder();
        inMemoryUserDetailsManager.createUser(user.username(userForm.getUsername()).password(userForm.getPassword()).roles("USER").build());
        
        return "redirect:/";
    }
}
