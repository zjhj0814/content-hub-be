package tibetyo.content_hub.dto.ott;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tibetyo.content_hub.entity.Ott;

@Getter
@AllArgsConstructor
public class OttResponseDto {
    private String name;

    public static OttResponseDto of(Ott ott) {
        return new OttResponseDto(ott.getName());
    }
}
