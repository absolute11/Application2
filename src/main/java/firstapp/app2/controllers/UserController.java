package firstapp.app2.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.io.IOException;

@Controller
@RequestMapping("/api")
public class UserController {

    @Value("${user.service.url}")
    private String userServiceUrl;

    @GetMapping("/users")
    public void getAllUsers(HttpServletResponse response) throws IOException {
        response.sendRedirect(userServiceUrl + "/customers");
    }
    @GetMapping("/users/{email}")
    public void getCustomerByEmail(HttpServletResponse response,@PathVariable String email) throws IOException{
        response.sendRedirect(userServiceUrl + "/customers/" + email);
    }
    @GetMapping("/roles")
    public void getAllRoles(HttpServletResponse response) throws IOException {
        response.sendRedirect(userServiceUrl + "/roles");
    }

    @GetMapping("/roles/{name}")
    public void getRoleByName(HttpServletResponse response, @PathVariable String name) throws IOException {
        response.sendRedirect(userServiceUrl + "/roles/" + name);
    }



}