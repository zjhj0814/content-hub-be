package tibetyo.content_hub.dto.content;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tibetyo.content_hub.entity.Content;
import tibetyo.content_hub.entity.ContentCategory;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ContentSummaryDto {
    private Long id;
    private String title;
    private ContentCategory category;
    private List<String> contentCastsNames;

    public static ContentSummaryDto of(Content content) {
        return new ContentSummaryDto(
                content.getId(),
                content.getTitle(),
                content.getCategory(),
                content.getContentCasts().stream()
                        .map(contentCast -> contentCast.getCast().getName())
                        .collect(Collectors.toList())
        );
    }
}
