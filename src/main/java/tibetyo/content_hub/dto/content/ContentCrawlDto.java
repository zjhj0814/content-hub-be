package tibetyo.content_hub.dto.content;

import lombok.AllArgsConstructor;
import lombok.Data;
import tibetyo.content_hub.entity.ContentCategory;
import tibetyo.content_hub.util.annotation.Enum;

import java.util.List;

@Data
@AllArgsConstructor
public class ContentCrawlDto {
    private String title;
    @Enum(enumClass = ContentCategory.class, message = "Invalid category", ignoreCase = true)
    private ContentCategory category;
    private List<String> casts;
    private String description;
}
