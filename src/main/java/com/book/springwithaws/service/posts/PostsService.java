package com.book.springwithaws.service.posts;

import com.book.springwithaws.domain.posts.Posts;
import com.book.springwithaws.domain.posts.PostsRepository;
import com.book.springwithaws.web.dto.PostSaveRequestDto;
import com.book.springwithaws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }


    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.id=" + id)
        );

        return new PostsResponseDto(posts);

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다.id=" + id)
        );
        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }
}
