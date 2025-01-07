package tibetyo.content_hub.repository.availability;

import org.springframework.data.jpa.repository.JpaRepository;
import tibetyo.content_hub.entity.Availability;
import tibetyo.content_hub.entity.Content;
import tibetyo.content_hub.entity.Ott;

import java.util.Optional;

public interface AvailabilityRepository extends JpaRepository<Availability, Long>, AvailabilityRepositoryCustom {
    Optional<Availability> findByContentAndOtt(Content content, Ott ott);
}