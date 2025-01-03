package tibetyo.content_hub.dto.availability;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import tibetyo.content_hub.entity.Availability;
import tibetyo.content_hub.entity.ContentStatus;

@Getter
public class AvailabilityResponseDto {
    private final Long contentId;
    private final String contentTitle;
    private final Long ottId;
    private final String ottName;
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
