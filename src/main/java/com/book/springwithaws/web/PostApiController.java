package com.book.springwithaws.web;

import com.book.springwithaws.service.posts.PostsResponseDto;
import com.book.springwithaws.service.posts.PostsService;
import com.book.springwithaws.web.dto.PostSaveRequestDto;
import com.book.springwithaws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;

    //등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto)
    {
        return postsService.save(requestDto);
    }

    //조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {
        return postsService.findById(id);
    }

    //수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto postsUpdateRequestDto){
        return postsService.update(id,postsUpdateRequestDto);
    }

    //삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id)
    {
        postsService.delete(id);
        return id;
    }


}
