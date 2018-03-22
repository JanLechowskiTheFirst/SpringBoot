package learningSpring.SpringBoot.controllers;

import learningSpring.SpringBoot.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminPageController {

    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/admin/admin")
    public String serveLoginnPage(Model model){
        model.addAttribute("role", userRoleService.getAllRoles());
        return "adminPage";
    }

    @PostMapping("/admin/admin/deleteAdmin")
    public String deleteAdmin(@RequestParam("userId") String userId){
        userRoleService.deleteAdminRole(Integer.parseInt(userId));
        return "redirect:/admin/admin";
    }

    @PostMapping("/admin/admin/addAdmin")
    public String addAdmin(@RequestParam("userId") String userId){
        userRoleService.addAdminAdmin(Integer.parseInt(userId));
        return "redirect:/admin/admin";
    }

}

