package tibetyo.content_hub.repository.like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tibetyo.content_hub.entity.Like;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("SELECT l FROM Like l LEFT JOIN l.content c WHERE l.user.id = :userId")
    List<Like> findLikesByUserId(@Param("userId") Long userId);

    Optional<Like> findByUserIdAndContentId(Long userId, Long contentId);

    void deleteAllByUserId(Long userId);

    boolean existsByUserIdAndContentId(Long userId, Long contentId);

    @Query("SELECT COUNT(l) FROM Like l WHERE l.content.id = :contentId")
    Long countLikesByContentId(@Param("contentId") Long contentId);
}
