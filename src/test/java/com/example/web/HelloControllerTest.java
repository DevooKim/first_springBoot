package com.example.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)    //스프링부트테스트와 JUnit 사이에 연결자
@WebMvcTest //스프링 테스트 어노테이션 중 Web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired  //스프링이 관리하는 bean을 주입받는다
    private MockMvc mvc;    //웹 API를 테스트할 떄 사용, 스프링 MVC 테스트의 시작점, GET, POST등에 대한 API를 테스트

    @Test
    public void helloIsReturn() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  //MockMvc를 통해 /hello 주소로 HTTP GET요청
                .andExpect(status().isOk()) //HTTP Header의 Status를 검증
                .andExpect(content().string(hello)); //mvc.perform의 결과를 검증
    }

    @Test
    public void helloDtoIsReturn() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
        /*
        param: API 테스트할 때 사용될 요청 파라미터를 설정(String만 허용)
        jsonPath: JSON 응답값을 필드별로 검증할 수 있는 메소드
        $를 기준으로 필드명을 명시
         */
    }

}
