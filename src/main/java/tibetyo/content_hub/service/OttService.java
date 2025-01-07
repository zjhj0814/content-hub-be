package tibetyo.content_hub.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tibetyo.content_hub.dto.ott.OttCreateRequestDto;
import tibetyo.content_hub.dto.ott.OttResponseDto;
import tibetyo.content_hub.entity.Ott;
import tibetyo.content_hub.exception.CustomException;
import tibetyo.content_hub.exception.ErrorCode;
import tibetyo.content_hub.repository.OttRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OttService {
    private final OttRepository ottRepository;

    public OttService(OttRepository ottRepository) {
        this.ottRepository = ottRepository;
    }

    public List<OttResponseDto> findAll() {
        return ottRepository.findAll()
                .stream()
                .map(OttResponseDto::of)
                .toList();
    }

    @Transactional
    public void addOtt(OttCreateRequestDto ottCreateRequestDto) {
        if (ottRepository.existsByName(ottCreateRequestDto.getName())) {
            throw new CustomException(ErrorCode.OTT_ALREADY_EXISTS);
        }
        Ott ott = Ott.builder().name(ottCreateRequestDto.getName()).build();
        ottRepository.save(ott);
    }

    @Transactional
    public void removeOtt(Long ottId) {
        Ott ott = ottRepository.findById(ottId)
                .orElseThrow(() -> new CustomException(ErrorCode.OTT_NOT_FOUND));
        ottRepository.delete(ott);
    }
}
