package kg.inai.equeuesystem.controllers;

import kg.inai.equeuesystem.entities.User;
import kg.inai.equeuesystem.services.CategoryService;
import kg.inai.equeuesystem.services.CountryService;
import kg.inai.equeuesystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    private User currentUser;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CountryService countryService;


    @PreAuthorize("isAuthenticated() and hasAuthority('SUPER_ADMIN')")
    @GetMapping("/category/list")
    public String getCategoryList(Model model) {
        setUserCredentials(model);
        model.addAttribute("title", "Список сфер деятельности");
        model.addAttribute("categories", categoryService.findAll());

        return "admin/category/category_list";
    }

    @PreAuthorize("isAuthenticated() and hasAuthority('SUPER_ADMIN')")
    @GetMapping("/country/list")
    public String getCountryList(Model model) {
        setUserCredentials(model);
        model.addAttribute("title", "Список стран");
        model.addAttribute("countries", countryService.findAll());

        return "admin/country/country_list";
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
