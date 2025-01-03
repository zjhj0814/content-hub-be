package tibetyo.content_hub.repository.like;

import tibetyo.content_hub.entity.Content;

import java.util.List;

public interface LikeRepositoryCustom {
    List<Content> findContentsOrderByLikes();
}
