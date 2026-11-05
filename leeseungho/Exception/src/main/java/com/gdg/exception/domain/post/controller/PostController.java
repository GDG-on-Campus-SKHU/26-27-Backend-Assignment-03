package com.gdg.exception.domain.post.controller;

import com.gdg.exception.domain.post.dto.request.PostSaveReqDto;
import com.gdg.exception.domain.post.dto.request.PostUpdateReqDto;
import com.gdg.exception.domain.post.dto.response.PostResDto;
import com.gdg.exception.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResDto> savePost(@RequestBody PostSaveReqDto postSaveReqDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(postSaveReqDto));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResDto> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @GetMapping
    public ResponseEntity<List<PostResDto>> getPosts() {
        return ResponseEntity.ok(postService.getAllPost());
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostResDto> updatePost(@PathVariable Long postId,
                                                 @RequestBody PostUpdateReqDto postUpdateReqDto) {
        return ResponseEntity.ok(postService.updatePost(postId, postUpdateReqDto));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}
