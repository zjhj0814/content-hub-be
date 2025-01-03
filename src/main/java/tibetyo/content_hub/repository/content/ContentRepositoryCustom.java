package tibetyo.content_hub.repository.content;

import tibetyo.content_hub.entity.Content;

import java.util.List;

public interface ContentRepositoryCustom {
    public List<Content> findContentsOrderByLikes();
}
