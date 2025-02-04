package tibetyo.content_hub.dto.availability;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import tibetyo.content_hub.entity.ContentStatus;
import tibetyo.content_hub.util.annotation.Enum;

@Getter
@AllArgsConstructor
public class AvailabilityUpdateDto {
    @NotNull
    @Schema(description = "availability id", example = "1")
    private Long availabilityId;
    @Enum(enumClass = ContentStatus.class, message = "Invalid status", ignoreCase = false)
    @Schema(description = "availability status", example = "SUBSCRIBER_PROVISION")
    private String status;
}
