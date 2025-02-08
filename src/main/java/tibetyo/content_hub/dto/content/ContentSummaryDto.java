package tibetyo.content_hub.dto.content;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tibetyo.content_hub.entity.Content;
import tibetyo.content_hub.entity.ContentCategory;

@Getter
@AllArgsConstructor
public class ContentSummaryDto {
    private Long id;
    private String title;
    private ContentCategory category;

    public static ContentSummaryDto of(Content content) {
        return new ContentSummaryDto(
                content.getId(),
                content.getTitle(),
                content.getCategory()
        );
    }
}
