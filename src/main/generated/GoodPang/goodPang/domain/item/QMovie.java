package GoodPang.goodPang.domain.item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMovie is a Querydsl query type for Movie
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMovie extends EntityPathBase<Movie> {

    private static final long serialVersionUID = 2132264927L;

    public static final QMovie movie = new QMovie("movie");

    public final QItem _super = new QItem(this);

    public final StringPath actor = createString("actor");

    //inherited
    public final EnumPath<GoodPang.goodPang.domain.enums.Category> category = _super.category;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath director = createString("director");

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

    public QMovie(String variable) {
        super(Movie.class, forVariable(variable));
    }

    public QMovie(Path<? extends Movie> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovie(PathMetadata metadata) {
        super(Movie.class, metadata);
    }

}

