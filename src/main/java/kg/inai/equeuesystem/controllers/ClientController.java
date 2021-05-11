package kg.inai.equeuesystem.controllers;

import kg.inai.equeuesystem.entities.User;
import kg.inai.equeuesystem.models.ClientModel;
import kg.inai.equeuesystem.models.EmployeeModel;
import kg.inai.equeuesystem.services.ClientService;
import kg.inai.equeuesystem.services.EmployeeService;
import kg.inai.equeuesystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/client")
public class ClientController {
    private User currentUser;

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String getClientRegForm(Model model) {
        return "client/client_registration";
    }

    @PostMapping("/registration")
    public String addClient(@ModelAttribute("UserModel") ClientModel clientModel) {
        clientModel.setRegistration_date(new Date(System.currentTimeMillis()));
        clientModel.getUserModel().setUserRoleId(2L);
        clientService.create(clientModel);
        return "redirect:/login";
    }

    public void setUserCredentials(Model model){
        getCurrentUser();
        model.addAttribute("name", currentUser.getUsername());
    }

    private void getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        currentUser = userService.getUserByUsername(userDetails.getUsername());
    }
}
