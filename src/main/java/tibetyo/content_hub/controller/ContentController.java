package tibetyo.content_hub.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tibetyo.content_hub.dto.ApiResponse;
import tibetyo.content_hub.dto.content.ContentCategoryRequestDto;
import tibetyo.content_hub.dto.content.ContentDetailDto;
import tibetyo.content_hub.dto.content.ContentResponseDto;
import tibetyo.content_hub.dto.content.ContentSummaryDto;
import tibetyo.content_hub.entity.ContentCategory;
import tibetyo.content_hub.service.ContentService;

import java.util.List;

@Tag(name = "Content API", description = "콘텐츠 관련 API")
@RestController
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;

    @GetMapping("/{contentId}")
    public ResponseEntity<ApiResponse<ContentDetailDto>> getContentDetail(@PathVariable Long contentId) {
        ContentDetailDto contentDetail = contentService.getContentDetail(contentId);
        ApiResponse<ContentDetailDto> response = new ApiResponse<>("Content details found successfully", contentDetail);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<ApiResponse<List<ContentSummaryDto>>> findContentByTitle(@RequestParam String title) {
        List<ContentSummaryDto> contents = contentService.findContentByTitle(title);
        ApiResponse<List<ContentSummaryDto>> response = new ApiResponse<>("Contents found successfully", contents);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<ApiResponse<List<ContentSummaryDto>>> findContentByCategory(
            @RequestBody @Valid ContentCategoryRequestDto categoryRequestDto) {
        List<ContentSummaryDto> contents = contentService.findContentByCategory(ContentCategory.valueOf(categoryRequestDto.getCategory()));
        ApiResponse<List<ContentSummaryDto>> response = new ApiResponse<>("Contents found successfully", contents);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/cast")
    public ResponseEntity<ApiResponse<List<ContentSummaryDto>>> findContentByCast(@RequestParam String castName) {
        List<ContentSummaryDto> contents = contentService.findContentByCast(castName);
        ApiResponse<List<ContentSummaryDto>> response = new ApiResponse<>("Contents found successfully", contents);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/top-likes")
    public ResponseEntity<ApiResponse<List<ContentResponseDto>>> findContentsByLikes() {
        List<ContentResponseDto> contents = contentService.findContentsByLikes();
        ApiResponse<List<ContentResponseDto>> response = new ApiResponse<>("Top liked contents found successfully", contents);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}