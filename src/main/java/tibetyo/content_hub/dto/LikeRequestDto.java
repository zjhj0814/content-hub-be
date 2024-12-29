package tibetyo.content_hub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LikeRequestDto {
    private Long userId;
    private Long contentId;
}
