package GoodPang.goodPang.domain.item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAlbum is a Querydsl query type for Album
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlbum extends EntityPathBase<Album> {

    private static final long serialVersionUID = 2121074462L;

    public static final QAlbum album = new QAlbum("album");

    public final QItem _super = new QItem(this);

    public final StringPath artist = createString("artist");

    //inherited
    public final EnumPath<GoodPang.goodPang.domain.enums.Category> category = _super.category;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath etc = createString("etc");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final ListPath<GoodPang.goodPang.domain.images.ItemImage, GoodPang.goodPang.domain.images.QItemImage> imageFiles = _super.imageFiles;

    //inherited
    public final StringPath information = _super.information;

    //inherited
    public final NumberPath<Integer> likes = _super.likes;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Integer> price = _super.price;

    //inherited
    public final NumberPath<Integer> stockQuantity = _super.stockQuantity;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAlbum(String variable) {
        super(Album.class, forVariable(variable));
    }

    public QAlbum(Path<? extends Album> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlbum(PathMetadata metadata) {
        super(Album.class, metadata);
    }

}

