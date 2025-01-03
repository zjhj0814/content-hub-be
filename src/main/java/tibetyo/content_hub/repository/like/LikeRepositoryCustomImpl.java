package tibetyo.content_hub.repository.like;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import tibetyo.content_hub.entity.Content;
import tibetyo.content_hub.entity.QContent;
import tibetyo.content_hub.entity.QLike;

import java.util.List;

import static tibetyo.content_hub.entity.QContent.*;
import static tibetyo.content_hub.entity.QLike.like;

@RequiredArgsConstructor
public class LikeRepositoryCustomImpl implements LikeRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Content> findContentsOrderByLikes() {
        return queryFactory
                .select(like.content)
                .from(like)
                .leftJoin(like.content)
                .fetchJoin()
                .groupBy(content.id)
                .orderBy()
    }
}
