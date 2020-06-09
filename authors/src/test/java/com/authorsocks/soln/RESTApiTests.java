package com.authorsocks.soln;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RESTApiTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getUsernamesTest() throws Exception {

        this.mvc.perform(get("/authors/active-list/3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[\"mpweiher\",\"coloneltcb\",\"olalonde\"]"))
                .andExpect(status().isOk());
    }

    @Test
    public void getUsernameWithHighestCommentCountTest() throws Exception {

        this.mvc.perform(get("/authors/highest-comment-count")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string("guelo"))
                .andExpect(status().isOk());
    }

    @Test
    public void getUsernamesSortedByRecordDateTest() throws Exception {

        this.mvc.perform(get("/authors/created-list/3")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[\"pkiller\",\"panny\",\"WisNorCan\"]"))
                .andExpect(status().isOk());
    }

}
