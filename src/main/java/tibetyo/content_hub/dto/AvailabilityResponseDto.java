package tibetyo.content_hub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tibetyo.content_hub.entity.Availability;
import tibetyo.content_hub.entity.ContentStatus;

@Getter
@AllArgsConstructor
public class AvailabilityResponseDto {
    private Long contentId;
    private String contentTitle;
    private Long ottId;
    private String ottName;
    private ContentStatus status;
}
