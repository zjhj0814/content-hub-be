package tibetyo.content_hub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tibetyo.content_hub.entity.Like;

@Getter
@AllArgsConstructor
public class LikeResponseDto {
    private Long userId;
    private Long contentId;
    private String contentTitle;
    public static LikeResponseDto of(Like like) {
        return new LikeResponseDto(
                like.getUser().getId(),
                like.getContent().getId(),
                like.getContent().getTitle()
        );
    }
}
