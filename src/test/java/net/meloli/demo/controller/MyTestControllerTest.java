package net.meloli.demo.controller;

import net.meloli.demo.sys.controller.MainController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTestControllerTest {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new MainController()).build();
    }

    @Test
    public void testGetMyName() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/main/index").accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
    }
}
