package tibetyo.content_hub.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAvailability is a Querydsl query type for Availability
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAvailability extends EntityPathBase<Availability> {

    private static final long serialVersionUID = -1879501429L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAvailability availability = new QAvailability("availability");

    public final QContent content;

    public final EnumPath<ContentStatus> contentStatus = createEnum("contentStatus", ContentStatus.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QOtt ott;

    public QAvailability(String variable) {
        this(Availability.class, forVariable(variable), INITS);
    }

    public QAvailability(Path<? extends Availability> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAvailability(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAvailability(PathMetadata metadata, PathInits inits) {
        this(Availability.class, metadata, inits);
    }

    public QAvailability(Class<? extends Availability> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.content = inits.isInitialized("content") ? new QContent(forProperty("content")) : null;
        this.ott = inits.isInitialized("ott") ? new QOtt(forProperty("ott")) : null;
    }

}

