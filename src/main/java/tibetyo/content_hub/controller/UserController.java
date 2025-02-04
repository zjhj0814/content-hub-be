package tibetyo.content_hub.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tibetyo.content_hub.dto.ApiResponse;
import tibetyo.content_hub.dto.user.UserCreateRequestDto;
import tibetyo.content_hub.dto.user.UserResponseDto;
import tibetyo.content_hub.service.UserService;

import java.util.List;

@Tag(name = "User API", description = "사용자 관련 API")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<ApiResponse<UserResponseDto>> signUp(@Valid @RequestBody UserCreateRequestDto userCreateRequestDto) {
        userService.signUp(userCreateRequestDto);
        ApiResponse<UserResponseDto> response = new ApiResponse<>("User signed up successfully", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> getUsers() {
        List<UserResponseDto> users = userService.findUsers();
        ApiResponse<List<UserResponseDto>> response = new ApiResponse<>("User found all", users);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserByEmail(@PathVariable String email) {
        UserResponseDto user = userService.findUser(email);
        ApiResponse<UserResponseDto> response = new ApiResponse<>("User found successfully", user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponseDto>> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        ApiResponse<UserResponseDto> response = new ApiResponse<>("User deleted successfully", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
