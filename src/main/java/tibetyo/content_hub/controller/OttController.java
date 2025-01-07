package tibetyo.content_hub.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tibetyo.content_hub.dto.ApiResponse;
import tibetyo.content_hub.dto.ott.OttResponseDto;
import tibetyo.content_hub.service.OttService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OttController {
    private final OttService ottService;

    @GetMapping("/ott/all")
    public ResponseEntity<ApiResponse<List<OttResponseDto>>> getAll() {
        List<OttResponseDto> otts = ottService.findAll();
        ApiResponse<List<OttResponseDto>> response = new ApiResponse<>("Ott found all", otts);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
