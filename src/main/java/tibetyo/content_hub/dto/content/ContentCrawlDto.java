package tibetyo.content_hub.dto.content;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import tibetyo.content_hub.entity.ContentCategory;
import tibetyo.content_hub.util.annotation.Enum;

import java.util.List;

@Data
@AllArgsConstructor
public class ContentCrawlDto {
    @Schema(name = "content title", example = "냉장고를 부탁해 2")
    private String title;
    @Schema(name = "content category", example = "DRAMA")
    @Enum(enumClass = ContentCategory.class, message = "Invalid category", ignoreCase = true)
    private ContentCategory category;
    @Schema(name = "content cast", example = "유재석")
    private List<String> casts;
    @Schema(name = "content description", example = "냉장고를 부탁하는 내용")
    private String description;
}
