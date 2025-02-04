package tibetyo.content_hub.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tibetyo.content_hub.dto.ApiResponse;
import tibetyo.content_hub.dto.availability.AvailabilityCreateRequestDto;
import tibetyo.content_hub.dto.availability.AvailabilityResponseDto;
import tibetyo.content_hub.dto.availability.AvailabilityUpdateDto;
import tibetyo.content_hub.entity.ContentStatus;
import tibetyo.content_hub.service.AvailabilityService;

import java.util.List;

@Tag(name = "Availability API", description = "이용가능성 관련 API")
@RestController
@RequiredArgsConstructor
public class AvailabilityController {
    private final AvailabilityService availabilityService;

    @PostMapping("/availabilities")
    public ResponseEntity<ApiResponse<AvailabilityResponseDto>> createAvailability(
            @Valid @RequestBody AvailabilityCreateRequestDto availabilityCreateRequestDto) {
        AvailabilityResponseDto availability = availabilityService.saveAvailability(availabilityCreateRequestDto);
        ApiResponse<AvailabilityResponseDto> response = new ApiResponse<>("Availability created successfully", availability);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/availabilities")
    public ResponseEntity<ApiResponse<AvailabilityResponseDto>> updateAvailability(
            @Valid @RequestBody AvailabilityUpdateDto availabilityUpdateDto) {
        AvailabilityResponseDto availability = availabilityService.updateAvailability(availabilityUpdateDto);
        ApiResponse<AvailabilityResponseDto> response = new ApiResponse<>("Availability updated successfully", availability);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/availabilities/content/{contentId}")
    public ResponseEntity<ApiResponse<List<AvailabilityResponseDto>>> getAvailability(@PathVariable Long contentId) {
        List<AvailabilityResponseDto> availabilities = availabilityService.findAvailabilitiesByContentId(contentId);
        ApiResponse<List<AvailabilityResponseDto>> response = new ApiResponse<>("Availability found", availabilities);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/availabilities/ott/{ottId}")
    public ResponseEntity<ApiResponse<List<AvailabilityResponseDto>>> getAvailabilityByOttId(@PathVariable Long ottId) {
        List<AvailabilityResponseDto> availabilities = availabilityService.findAvailabilitiesByOttId(ottId);
        ApiResponse<List<AvailabilityResponseDto>> response = new ApiResponse<>("Availability found", availabilities);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //@RequestParam AvailabilitiesFindDto
    //List<ContentStatus>에 대한 어노테이션 생성 요망
    @GetMapping("/availabilities/ott/status")
    public ResponseEntity<ApiResponse<List<AvailabilityResponseDto>>> getAvailabilityByOttStatus(
            @RequestParam Long ottId,
            @RequestParam List<ContentStatus> statuses
    ) {
        List<AvailabilityResponseDto> availabilities = availabilityService.findAvailabilitiesByOttAndStatus(ottId, statuses);
        ApiResponse<List<AvailabilityResponseDto>> response = new ApiResponse<>("Availability found", availabilities);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
