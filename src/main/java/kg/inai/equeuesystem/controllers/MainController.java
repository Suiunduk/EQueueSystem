package kg.inai.equeuesystem.controllers;

import kg.inai.equeuesystem.entities.User;
import kg.inai.equeuesystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private User currentUser;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMainPage(Model model) {
        getCurrentUser();
        if (currentUser != null) {
            setUserCredentials(model);
        }
        return "index";
    }

    public void setUserCredentials(Model model){
        getCurrentUser();
        model.addAttribute("name", currentUser.getUsername());
    }

    private void getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() != "anonymousUser") {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            currentUser = userService.getUserByUsername(userDetails.getUsername());
        }
    }
}
