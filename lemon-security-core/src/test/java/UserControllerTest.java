import com.zzidc.web.MainApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName UserControllerTest
 * @Author chenxue
 * @Description TODO
 * @Date 2019/3/29 14:06
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    /*
    * @Author chenxue
     * @Description //TODO
     * @Date 2019/3/29 14:25
     * @Param []
     * @return void
     **/
    @Test
    public void query1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    @Test
    public void query2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user2")
                .param("username","tom")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    @Test
    public void query3() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.get("/user3/tom")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    @Test
    public void query4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user4")
                .param("page","1")
                .param("size","3")
                .param("sort","username,desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }
    @Test
    public void getInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getInfo/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("Tom"));
    }

    @Test
    public void getSimpleUser() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/getSimpleUser")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }
    @Test
    public void getDetailUser() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/getDetailUser")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void create1() throws Exception {
        String content = "{\"username\":\"Tom\",\"password\":\"123456\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/user1")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void create2() throws Exception {
        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        String content = "{\"username\":null,\"password\":null,\"birthday\":" + date.getTime() +",\"idCard\":\"1111\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/user2")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2));
    }
    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/user/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("Tom"));
    }

    @Test
    public void demo(){
        System.out.println(LocalDateTime.now());
    }
}
