package tibetyo.content_hub.repository.availability;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import tibetyo.content_hub.dto.availability.AvailabilityResponseDto;
import tibetyo.content_hub.dto.availability.QAvailabilityResponseDto;
import tibetyo.content_hub.entity.ContentStatus;

import java.util.List;

import static tibetyo.content_hub.entity.QAvailability.availability;
import static tibetyo.content_hub.entity.QContent.content;
import static tibetyo.content_hub.entity.QOtt.ott;

@RequiredArgsConstructor
public class AvailabilityRepositoryCustomImpl implements AvailabilityRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<AvailabilityResponseDto> findAvailabilitiesByContentId(Long contentId) {
        return queryFactory
                .select(
                        new QAvailabilityResponseDto(
                                availability.content.id,
                                availability.content.title,
                                availability.ott.id,
                                availability.ott.name,
                                availability.contentStatus
                        )
                )
                .from(availability)
                .leftJoin(availability.content, content)
                .leftJoin(availability.ott, ott)
                .where(availability.content.id.eq(contentId))
                .fetch();
    }

    @Override
    public List<AvailabilityResponseDto> findAvailabilitiesByOtt(Long ottId) {
        return queryFactory
                .select(
                        new QAvailabilityResponseDto(
                                availability.content.id,
                                availability.content.title,
                                availability.ott.id,
                                availability.ott.name,
                                availability.contentStatus
                        )
                )
                .from(availability)
                .leftJoin(availability.content, content)
                .leftJoin(availability.ott, ott)
                .where(
                        availability.ott.id.eq(ottId)
                                .and(availability.contentStatus.in(
                                        ContentStatus.FREE,
                                        ContentStatus.SUBSCRIBER_PROVISION,
                                        ContentStatus.INDIVIDUAL_PURCHASE
                                ))
                )
                .fetch();
    }

    @Override
    public List<AvailabilityResponseDto> findAvailabilitiesByOttAndStatus(Long ottId, List<ContentStatus> contentStatuses) {
        return queryFactory
                .select(
                        new QAvailabilityResponseDto(
                                availability.content.id,
                                availability.content.title,
                                availability.ott.id,
                                availability.ott.name,
                                availability.contentStatus
                        )
                )
                .from(availability)
                .leftJoin(availability.content, content)
                .leftJoin(availability.ott, ott)
                .where(
                        availability.ott.id.eq(ottId)
                                .and(availability.contentStatus.in(contentStatuses))
                )
                .fetch();
    }
}
