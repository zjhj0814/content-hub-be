package tibetyo.content_hub.repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tibetyo.content_hub.entity.Content;
import tibetyo.content_hub.entity.ContentCategory;

import java.util.List;
import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long>, ContentRepositoryCustom {
    Optional<Content> findById(Long id);

    @Query("SELECT DISTINCT c FROM Content c " +
            "LEFT JOIN FETCH c.contentCasts cc " +
            "LEFT JOIN FETCH cc.cast " +
            "WHERE c.id = :contentId")
    Optional<Content> findContentAndCastByContentId(@Param("contentId") Long contentId);

    @Query("SELECT DISTINCT c FROM Content c " +
            "LEFT JOIN FETCH c.contentCasts cc " +
            "LEFT JOIN FETCH cc.cast " +
            "WHERE LOWER(c.title) LIKE LOWER(CONCAT('%',:title,'%'))")
    List<Content> findContentsByTitle(@Param("title") String title);

    List<Content> findContentsByCategory(ContentCategory category);

    @Query("SELECT DISTINCT c FROM Content c " +
            "LEFT JOIN FETCH c.contentCasts cc " +
            "LEFT JOIN FETCH cc.cast cast " +
            "WHERE LOWER(cast.name) LIKE LOWER(CONCAT('%', :castName, '%'))")
    List<Content> findContentsByCastName(@Param("castName") String castName);
}
