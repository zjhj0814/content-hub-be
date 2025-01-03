package tibetyo.content_hub.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tibetyo.content_hub.dto.user.UserCreateRequestDto;
import tibetyo.content_hub.dto.user.UserResponseDto;
import tibetyo.content_hub.entity.User;
import tibetyo.content_hub.exception.CustomException;
import tibetyo.content_hub.exception.ErrorCode;
import tibetyo.content_hub.repository.UserRepository;
import tibetyo.content_hub.repository.like.LikeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
public class UserService {
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;

    public UserService(UserRepository userRepository, LikeRepository likeRepository) {
        this.userRepository = userRepository;
        this.likeRepository = likeRepository;
    }

    @Transactional
    public void signUp(UserCreateRequestDto userCreateRequestDto) {
        if (userRepository.existsByEmail(userCreateRequestDto.getEmail())) {
            throw new CustomException(ErrorCode.EMAIL_DUPLICATE);
        }
        User user = userCreateRequestDto.toEntity();
        userRepository.save(user);
    }

    public List<UserResponseDto> findUsers() {
        return userRepository.findAll().stream().map(UserResponseDto::of).collect(Collectors.toList());
    }

    public UserResponseDto findUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(UserResponseDto::of).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        likeRepository.deleteAllByUserId(userId);
        userRepository.delete(user);
    }
}
