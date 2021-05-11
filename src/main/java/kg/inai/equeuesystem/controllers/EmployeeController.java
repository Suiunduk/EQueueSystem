package kg.inai.equeuesystem.controllers;

import kg.inai.equeuesystem.entities.User;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private User currentUser;

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/registration")
    public String getEmployeeRegForm(Model model) {
        return "employee/employee_registration";
    }

    @PostMapping("/registration")
    public String addEmployee(@ModelAttribute("UserModel") EmployeeModel employeeModel) {
        employeeModel.setRegistration_date(new Date(System.currentTimeMillis()));
        employeeModel.getUserModel().setUserRoleId(3L);
        employeeService.create(employeeModel);
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
