package tibetyo.content_hub.repository.content;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import tibetyo.content_hub.entity.Content;

import java.util.List;

import static tibetyo.content_hub.entity.QContent.content;
import static tibetyo.content_hub.entity.QLike.like;

@RequiredArgsConstructor
public class ContentRepositoryCustomImpl implements ContentRepositoryCustom {
    private JPAQueryFactory queryFactory;

    @Override
    public List<Content> findContentsOrderByLikes() {
        return queryFactory
                .selectFrom(content)
                .leftJoin(like)
                .on(like.content.eq(content))
                .groupBy(content.id)
                .orderBy(like.count().desc())
                .fetch();
    }
}
