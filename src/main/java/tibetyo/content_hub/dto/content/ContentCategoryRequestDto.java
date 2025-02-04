package tibetyo.content_hub.dto.content;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import tibetyo.content_hub.entity.ContentCategory;
import tibetyo.content_hub.util.annotation.Enum;

@Getter
public class ContentCategoryRequestDto {
    @Enum(enumClass = ContentCategory.class, message = "Invalid category", ignoreCase = false)
    @Schema(name = "content category", example = "DRAMA")
    private String category;
}
