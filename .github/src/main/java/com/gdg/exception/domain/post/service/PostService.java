package com.gdg.exception.domain.post.service;

import com.gdg.exception.domain.member.entity.Member;
import com.gdg.exception.domain.member.repository.MemberRepository;
import com.gdg.exception.domain.post.dto.request.PostSaveReqDto;
import com.gdg.exception.domain.post.dto.request.PostUpdateReqDto;
import com.gdg.exception.domain.post.dto.response.PostResDto;
import com.gdg.exception.domain.post.entity.Post;
import com.gdg.exception.domain.post.repository.PostRepository;
import com.gdg.exception.global.exeption.ErrorCode;
import com.gdg.exception.global.exeption.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public PostResDto savePost(PostSaveReqDto postSaveReqDto) {
        Member member = memberRepository.findById(postSaveReqDto.memberId())
                .orElseThrow(() -> new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        Post post = Post.builder()
                .title(postSaveReqDto.title())
                .contents(postSaveReqDto.contents())
                .member(member)
                .build();

        postRepository.save(post);
        return PostResDto.from(post);
    }

    public PostResDto getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.POST_NOT_FOUND));

        return PostResDto.from(post);
    }

    public List<PostResDto> getAllPost() {
        return postRepository.findAll().stream()
                .map(PostResDto::from)
                .toList();
    }

    @Transactional
    public PostResDto updatePost(Long postId, PostUpdateReqDto postUpdateReqDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.POST_NOT_FOUND));

        post.update(postUpdateReqDto);
        return PostResDto.from(post);
    }

    @Transactional
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.POST_NOT_FOUND));

        postRepository.delete(post);
    }
}
