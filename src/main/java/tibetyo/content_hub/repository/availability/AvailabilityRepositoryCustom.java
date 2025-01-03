package tibetyo.content_hub.repository.availability;

import tibetyo.content_hub.dto.availability.AvailabilityResponseDto;
import tibetyo.content_hub.entity.ContentStatus;

import java.util.List;

public interface AvailabilityRepositoryCustom {
    List<AvailabilityResponseDto> findAvailabilitiesByContentId(Long contentId);

    List<AvailabilityResponseDto> findAvailabilitiesByOtt(Long ottId);

    List<AvailabilityResponseDto> findAvailabilitiesByOttAndStatus(Long ottId, List<ContentStatus> contentStatuses);
}
