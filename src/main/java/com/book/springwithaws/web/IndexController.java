package com.book.springwithaws.web;

import com.book.springwithaws.domain.posts.Posts;
import com.book.springwithaws.domain.posts.PostsRepository;
import com.book.springwithaws.service.posts.PostsResponseDto;
import com.book.springwithaws.service.posts.PostsService;
import com.book.springwithaws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsRepository postsRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        List<Posts> postsList = postsRepository.findAllDesc();
        model.addAttribute("posts",postsList);
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
    }

    @GetMapping("posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 아이디가 존재하지 않습니다.")
        );
        PostsResponseDto postsResponseDto = new PostsResponseDto(posts);

        model.addAttribute("post",postsResponseDto);
        return "posts-update";
    }
}
