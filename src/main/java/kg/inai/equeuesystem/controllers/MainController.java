package kg.inai.equeuesystem.controllers;

import kg.inai.equeuesystem.models.UserModel;
import kg.inai.equeuesystem.services.UserRoleService;
import kg.inai.equeuesystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/")
    public String getMainPage(Model model) {

        return "index";
    }

    @GetMapping("/client/registration")
    public String getClientRegForm(Model model) {
        return "client_registration";
    }

    @PostMapping("/client/registration")
    public String addClient(@ModelAttribute("UserModel")UserModel userModel) {
        userModel.setUserRoleId(2L);
        userService.create(userModel);
        return "redirect:/login";
    }
}
