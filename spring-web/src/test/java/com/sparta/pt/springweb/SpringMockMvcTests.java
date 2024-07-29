package com.sparta.pt.springweb;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@SpringBootTest
@AutoConfigureMockMvc
public class SpringMockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testWelcomePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testWelcomePageContent() throws Exception {
        String content = mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        MatcherAssert.assertThat(content, Matchers.containsString("Welcome"));
    }

    @Test
    void testWelcomePageExpectations() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Welcome")))
                .andExpect(MockMvcResultMatchers.model().attributeExists("date"))
                .andExpect(MockMvcResultMatchers.content().contentType("text/html;charset=UTF-8"));
    }

    @Test
    void testAuthorsPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/authors"))
                .andDo(MockMvcResultHandlers.print());
    }
}
