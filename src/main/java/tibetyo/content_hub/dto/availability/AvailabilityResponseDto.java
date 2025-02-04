package tibetyo.content_hub.dto.availability;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import tibetyo.content_hub.entity.Availability;
import tibetyo.content_hub.entity.ContentStatus;

@Getter
public class AvailabilityResponseDto {
    @Schema(name = "content id", example = "1")
    private final Long contentId;
    @Schema(name = "content title", example = "우아한 가")
    private final String contentTitle;
    @Schema(name = "ott id", example = "1")
    private final Long ottId;
    @Schema(name = "ott name", example = "wavve")
    private final String ottName;
    @Schema(name = "content status", example = "FREE")
    private final ContentStatus status;

    @QueryProjection
    public AvailabilityResponseDto(Long contentId, String contentTitle, Long ottId, String ottName, ContentStatus status) {
        this.contentId = contentId;
        this.contentTitle = contentTitle;
        this.ottId = ottId;
        this.ottName = ottName;
        this.status = status;
    }

    public static AvailabilityResponseDto of(Availability availability) {
        return new AvailabilityResponseDto(
                availability.getContent().getId(),
                availability.getContent().getTitle(),
                availability.getOtt().getId(),
                availability.getOtt().getName(),
                availability.getContentStatus()
        );
    }
}
