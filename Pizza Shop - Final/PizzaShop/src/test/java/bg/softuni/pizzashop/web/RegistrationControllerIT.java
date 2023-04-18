package bg.softuni.pizzashop.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
        void testRegisterGetShown() throws Exception {
            mockMvc
                    .perform(get("http://localhost:8080/users/register")).andExpect(status().isOk())
                    .andExpect(view().name("register"));
        }
    }




//    @Test
//    void testRegistration() throws Exception {
//        mockMvc.perform(post("/users/register")
//                .param("username", "manager")
//                .param("fullName", "manager")
//                .param("email", "manager@email.com")
//                .param("phone", "087868697")
//                .param("password", "manager")
//                .param("passwordConfirm", "manager")
//                .param("city", "City")
//                .param("center", "Center")
//                .param("street", "Street")
//                .param("streetNumber", "1")
//                .with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/users/login"));
//    }