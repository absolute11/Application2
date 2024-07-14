package firstapp.app2.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Value("${user.service.url}")
    private String userServiceUrl;

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(userServiceUrl + "/customers"));
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testGetCustomerByEmail() throws Exception {
        String email = "test@example.com";
        mockMvc.perform(get("/api/users/" + email))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(userServiceUrl + "/customers/" + email));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetAllRoles() throws Exception {
        mockMvc.perform(get("/api/roles"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(userServiceUrl + "/roles"));
    }
    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetRoleByName() throws Exception {
        String roleName = "ROLE_USER";
        mockMvc.perform(get("/api/roles/" + roleName))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(userServiceUrl + "/roles/" + roleName));
    }

}