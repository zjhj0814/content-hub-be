package tibetyo.content_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tibetyo.content_hub.entity.Ott;

import java.util.Optional;

public interface OttRepository extends JpaRepository<Ott, Long> {
    Optional<Ott> findByName(String name);
}
