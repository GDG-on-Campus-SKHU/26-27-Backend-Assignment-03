package com.gdg.exception.domain.post.dto.response;

import com.gdg.exception.domain.post.entity.Post;
import lombok.Builder;

@Builder
public record PostResDto(
        Long postId,
        String title,
        String contents,
        Long memberId,
        String memberName
) {
    public static PostResDto from(Post post) {
        return PostResDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .contents(post.getContents())
                .memberId(post.getMember().getMemberId())
                .memberName(post.getMember().getName())
                .build();
    }
}
