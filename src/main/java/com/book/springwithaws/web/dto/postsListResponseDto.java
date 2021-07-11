package com.book.springwithaws.web.dto;

import com.book.springwithaws.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class postsListResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;

    public postsListResponseDto(Posts posts)
    {
        this.id=posts.getId();
        this.title=posts.getTitle();
        this.content= posts.getContent();
        this.author= posts.getAuthor();
        this.modifiedDate=posts.getModifiedDate();
    }
}


