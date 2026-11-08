package com.gdg.exception.domain.post.repository;

import com.gdg.exception.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
