package com.book.springwithaws.service.posts;

import com.book.springwithaws.domain.posts.Posts;
import com.book.springwithaws.domain.posts.PostsRepository;
import com.book.springwithaws.web.dto.PostSaveRequestDto;
import com.book.springwithaws.web.dto.PostsUpdateRequestDto;
import com.book.springwithaws.web.dto.postsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    //게시글 저장
    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    //게시글 하나 조회
    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.id=" + id)
        );

        return new PostsResponseDto(posts);

    }

    //게시글 수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다.id=" + id)
        );
        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    //게시글 전체 조회
    public List<postsListResponseDto> findAllDesc()
    {
        return postsRepository.findAllDesc().stream()
                .map(postsListResponseDto::new)
                .collect(Collectors.toList());

    }

    //게시글 삭제
    @Transactional
    public Long delete(Long id)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디는 존재하지 않습니다.")
        );
        postsRepository.delete(posts);
        return id;

    }
}
