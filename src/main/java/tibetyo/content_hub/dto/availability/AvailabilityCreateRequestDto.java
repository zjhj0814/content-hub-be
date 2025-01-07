package tibetyo.content_hub.dto.availability;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import tibetyo.content_hub.entity.ContentStatus;
import tibetyo.content_hub.util.annotation.Enum;

@Getter
@AllArgsConstructor
public class AvailabilityCreateRequestDto {
    @NotNull
    private Long contentId;
    @NotBlank
    private String ottName;
    @Enum(enumClass = ContentStatus.class, message = "Invalid status", ignoreCase = true)
    private String status;
}
