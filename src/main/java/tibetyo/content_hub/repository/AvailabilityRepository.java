package tibetyo.content_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tibetyo.content_hub.dto.AvailabilityResponseDto;
import tibetyo.content_hub.entity.Availability;
import tibetyo.content_hub.entity.ContentStatus;

import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    @Query("SELECT new tibetyo.content_hub.dto.AvailabilityResponseDto("
            +"a.content.id, a.content.title, a.ott.id, a.ott.name, a.contentStatus) " +
            "FROM Availability a LEFT JOIN FETCH a.content c LEFT JOIN FETCH a.ott o " +
            "WHERE a.content.id = :contentId")
    List<AvailabilityResponseDto> findAvailabilitiesByContentId(@Param("contentId") Long contentId);

    @Query("SELECT new tibetyo.content_hub.dto.AvailabilityResponseDto("
            +"a.content.id, a.content.title, a.ott.id, a.ott.name, a.contentStatus) " +
            "FROM Availability a LEFT JOIN FETCH a.content c LEFT JOIN FETCH a.ott o " +
            "WHERE a.ott.id = :ottId AND a.contentStatus IN (:statuses)")
    List<AvailabilityResponseDto> findAvailabilitiesByOttId(@Param("ottId") Long ottId, @Param("statuses") List<ContentStatus> statuses);
}
