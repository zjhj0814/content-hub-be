package tibetyo.content_hub.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOtt is a Querydsl query type for Ott
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOtt extends EntityPathBase<Ott> {

    private static final long serialVersionUID = 274643199L;

    public static final QOtt ott = new QOtt("ott");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QOtt(String variable) {
        super(Ott.class, forVariable(variable));
    }

    public QOtt(Path<? extends Ott> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOtt(PathMetadata metadata) {
        super(Ott.class, metadata);
    }

}

