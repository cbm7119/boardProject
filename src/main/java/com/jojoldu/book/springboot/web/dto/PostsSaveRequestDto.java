package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


//Entity 클래스를 Request/Response 클래스로 사용해서는 안된다. Dto 클래스를 추가로 생성해라.
// Controller에서 결과값으로 여러 테이블을 조인해서 줘야 할 경우가 빈번하므로 Entity 클래스만으로 표현하기가 어려운 경우가 많다.
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
