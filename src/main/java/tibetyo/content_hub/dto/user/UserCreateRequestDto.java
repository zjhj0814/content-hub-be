package tibetyo.content_hub.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tibetyo.content_hub.entity.User;

@Getter
@AllArgsConstructor
public class UserCreateRequestDto {
    private String email;
    private String password;

    public User toEntity() {
        return new User(this.email, this.password);
    }
}
