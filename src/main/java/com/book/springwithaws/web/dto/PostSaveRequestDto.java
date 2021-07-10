package com.book.springwithaws.web.dto;

import com.book.springwithaws.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //DTO -> Posts Entity로
    public Posts toEntity()
    {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
