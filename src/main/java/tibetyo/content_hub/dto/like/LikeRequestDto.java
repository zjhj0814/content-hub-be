package tibetyo.content_hub.dto.like;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LikeRequestDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long contentId;
}
