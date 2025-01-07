package tibetyo.content_hub.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tibetyo.content_hub.entity.User;


@Getter
@AllArgsConstructor
public class UserResponseDto {
    private String email;

    public static UserResponseDto of(User user) {
        return new UserResponseDto(user.getEmail());
    }
}
