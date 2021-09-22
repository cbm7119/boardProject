package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
Entity 클래스에서는 절대 Setter 메서드를 만들지 않는다.
대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 한다.
 */
@Getter //Getter 메소드 자동 생성
@NoArgsConstructor  //기본 생성자 자동 추가
@Entity //테이블과 링크될 클래스임을 나타낸다.
public class Posts extends BaseTimeEntity{
    @Id //테이블의 PK필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙을 나타낸다. GenerationType.IDENTITY 옵션을 추가해야 AUTO-Increment된다.
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 컬럼값
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    1. 인자가 많을 경우 쉽고 안전하게 객체를 생성할 수 있습니다.
    2. 인자의 순서와 상관없이 객체를 생성할 수 있습니다.
    3. 적절한 책임을 이름에 부여하여 가독성을 높일 수 있습니다.*/
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
