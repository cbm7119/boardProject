package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class) //테스트 진행할 때 Junit에 내장된 실행자 외에 다른 실장자를 실행시킨다. 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한ㄴ다.
@WebMvcTest(controllers = HelloController.class) //여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션이다. 선언할 경우 @Controller @ControllerAdvice 등을 사용할 수 있다. @Service, @Component, @Repository등은 사용할 수 없다.
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;    //HTTP GET, POST 등에 대한 API 테스으를 할 수 있스빈다.

    @Test
    public void test_helloController() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) //perform의 결과를 검증, HTTP Header의 Status를 검증
                .andExpect(content().string(hello));
    }

    @Test
    public void test_helloDto() throws Exception {
        String name = "bomin";
        int amount = 100000000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
