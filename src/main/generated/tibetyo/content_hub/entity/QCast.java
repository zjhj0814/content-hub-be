package tibetyo.content_hub.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCast is a Querydsl query type for Cast
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCast extends EntityPathBase<Cast> {

    private static final long serialVersionUID = -76371089L;

    public static final QCast cast = new QCast("cast");

    public final ListPath<ContentCast, QContentCast> contentCasts = this.<ContentCast, QContentCast>createList("contentCasts", ContentCast.class, QContentCast.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QCast(String variable) {
        super(Cast.class, forVariable(variable));
    }

    public QCast(Path<? extends Cast> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCast(PathMetadata metadata) {
        super(Cast.class, metadata);
    }

}

