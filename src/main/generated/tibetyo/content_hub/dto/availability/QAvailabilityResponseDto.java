package tibetyo.content_hub.dto.availability;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * tibetyo.content_hub.dto.availability.QAvailabilityResponseDto is a Querydsl Projection type for AvailabilityResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAvailabilityResponseDto extends ConstructorExpression<AvailabilityResponseDto> {

    private static final long serialVersionUID = 1046567354L;

    public QAvailabilityResponseDto(com.querydsl.core.types.Expression<Long> contentId, com.querydsl.core.types.Expression<String> contentTitle, com.querydsl.core.types.Expression<Long> ottId, com.querydsl.core.types.Expression<String> ottName, com.querydsl.core.types.Expression<tibetyo.content_hub.entity.ContentStatus> status) {
        super(AvailabilityResponseDto.class, new Class<?>[]{long.class, String.class, long.class, String.class, tibetyo.content_hub.entity.ContentStatus.class}, contentId, contentTitle, ottId, ottName, status);
    }

}

