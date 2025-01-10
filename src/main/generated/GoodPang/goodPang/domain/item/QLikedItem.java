package GoodPang.goodPang.domain.item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLikedItem is a Querydsl query type for LikedItem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLikedItem extends EntityPathBase<LikedItem> {

    private static final long serialVersionUID = -873190001L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLikedItem likedItem = new QLikedItem("likedItem");

    public final GoodPang.goodPang.domain.base.QBaseEntity _super = new GoodPang.goodPang.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QItem item;

    public final GoodPang.goodPang.domain.member.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QLikedItem(String variable) {
        this(LikedItem.class, forVariable(variable), INITS);
    }

    public QLikedItem(Path<? extends LikedItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLikedItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLikedItem(PathMetadata metadata, PathInits inits) {
        this(LikedItem.class, metadata, inits);
    }

    public QLikedItem(Class<? extends LikedItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.item = inits.isInitialized("item") ? new QItem(forProperty("item")) : null;
        this.member = inits.isInitialized("member") ? new GoodPang.goodPang.domain.member.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

