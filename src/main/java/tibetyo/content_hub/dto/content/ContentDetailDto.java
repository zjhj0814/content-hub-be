package tibetyo.content_hub.dto.content;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tibetyo.content_hub.entity.Content;
import tibetyo.content_hub.entity.ContentCategory;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ContentDetailDto {
    private Long id;
    private String title;
    private String description;
    private ContentCategory category;
    private List<String> contentCastsNames;
    @Setter
    private Long likes;

    public static ContentDetailDto of(Content content){
        return new ContentDetailDto(
                content.getId(),
                content.getTitle(),
                content.getDescription(),
                content.getCategory(),
                content.getContentCasts().stream()
                        .map(contentCast -> contentCast.getCast().getName())
                        .collect(Collectors.toList()),
                0L
        );
    }
}
