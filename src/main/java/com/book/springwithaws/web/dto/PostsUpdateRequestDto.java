package com.book.springwithaws.web.dto;

import com.book.springwithaws.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostsUpdateRequestDto {

    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title,String content)
    {
        this.title= title;
        this.content= content;
    }

}