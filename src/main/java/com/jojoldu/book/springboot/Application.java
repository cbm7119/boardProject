package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //JPA Auditing 활성화
@SpringBootApplication  //스프링 부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정. // SpringApplication.run으로 인해 내장 WAS를 실행한다. 톱캣을 설치할 필요가 없게 되고, 스프링 부트로 만들어진 Jar 파일로 실행하면된다.
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
