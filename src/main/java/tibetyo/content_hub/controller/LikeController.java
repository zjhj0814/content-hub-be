package tibetyo.content_hub.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tibetyo.content_hub.dto.ApiResponse;
import tibetyo.content_hub.dto.like.LikeRequestDto;
import tibetyo.content_hub.dto.like.LikeResponseDto;
import tibetyo.content_hub.service.LikeService;

import java.util.List;

@Tag(name = "Like API", description = "좋아요 관련 API")
@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping()
    public ResponseEntity<ApiResponse<LikeResponseDto>> addLike(@Valid @RequestBody LikeRequestDto likeRequestDto) {
        likeService.addLike(likeRequestDto);
        ApiResponse<LikeResponseDto> response = new ApiResponse<>("Like added successfully", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity<ApiResponse<LikeResponseDto>> removeLike(@Valid @RequestBody LikeRequestDto likeRequestDto) {
        likeService.removeLike(likeRequestDto);
        ApiResponse<LikeResponseDto> response = new ApiResponse<>("Like removed successfully", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<LikeResponseDto>>> getLikesByUser(@PathVariable Long userId) {
        List<LikeResponseDto> likes = likeService.findLikesByUser(userId);
        ApiResponse<List<LikeResponseDto>> response = new ApiResponse<>("User likes found successfully", likes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/content/{contentId}/count")
    public ResponseEntity<ApiResponse<Long>> countLikesByContent(@PathVariable Long contentId) {
        Long count = likeService.countLikesByContent(contentId);
        ApiResponse<Long> response = new ApiResponse<>("Like count found successfully", count);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
