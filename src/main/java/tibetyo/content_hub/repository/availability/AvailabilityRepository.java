package tibetyo.content_hub.repository.availability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tibetyo.content_hub.dto.availability.AvailabilityResponseDto;
import tibetyo.content_hub.entity.Availability;

import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Long>, AvailabilityRepositoryCustom {
}