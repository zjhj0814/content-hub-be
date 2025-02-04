package tibetyo.content_hub.dto.availability;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(name = "content id", example = "1")
    private Long contentId;
    @NotBlank
    @Schema(name = "ott name", example = "wavve")
    private String ottName;
    @Schema(name = "content status", example = "FREE")
    @Enum(enumClass = ContentStatus.class, message = "Invalid status", ignoreCase = false)
    private String status;
}
