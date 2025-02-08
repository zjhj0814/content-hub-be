package tibetyo.content_hub.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QContentCast is a Querydsl query type for ContentCast
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QContentCast extends EntityPathBase<ContentCast> {

    private static final long serialVersionUID = 732199208L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QContentCast contentCast = new QContentCast("contentCast");

    public final QCast cast;

    public final QContent content;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QContentCast(String variable) {
        this(ContentCast.class, forVariable(variable), INITS);
    }

    public QContentCast(Path<? extends ContentCast> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QContentCast(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QContentCast(PathMetadata metadata, PathInits inits) {
        this(ContentCast.class, metadata, inits);
    }

    public QContentCast(Class<? extends ContentCast> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cast = inits.isInitialized("cast") ? new QCast(forProperty("cast")) : null;
        this.content = inits.isInitialized("content") ? new QContent(forProperty("content")) : null;
    }

}

