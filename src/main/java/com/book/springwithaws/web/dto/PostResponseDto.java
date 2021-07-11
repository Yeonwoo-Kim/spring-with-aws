package com.book.springwithaws.web.dto;

import com.book.springwithaws.domain.posts.Posts;

public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostResponseDto(Posts posts)
    {
        this.id= posts.getId();
        this.title= posts.getTitle();
        this.content= posts.getContent();
        this.author= posts.getAuthor();
    }

}
