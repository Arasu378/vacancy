package com.arasu.vacancy;

import com.arasu.vacancy.entity.User;
import com.arasu.vacancy.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    @Test
    void userGetAllUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        User user = new User();
        User user2 = new User();
        user.setFirstName("Thirunavukkarasu");
        user2.setFirstName("Lokesh");
        user.setLastName("v");
        user2.setLastName("P");
        user.setEmail("v.t.a378@gmail.com");
        user2.setEmail("lokesh.theman@gmail.com");
        userList.add(user);
        userList.add(user2);
        when(userService.getAll()).thenReturn(userList);
        mockMvc.perform(MockMvcRequestBuilders.get("/all")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(2))).andDo(print());
    }
}
