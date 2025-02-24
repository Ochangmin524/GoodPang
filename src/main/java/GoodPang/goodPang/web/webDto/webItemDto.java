package GoodPang.goodPang.web.webDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class webItemDto {

    @Builder
    @Getter
    @Setter
    public static class ItemDto {
        Long id;
        String name;
        Integer price;
        Integer quantity;
        Integer likes;

    }
    @Builder
    @Getter
    @Setter
    public static class ItemDetailDto {
        Long id;
        String name;
        Integer price;
        Integer quantity;
        Integer likes;
        String information;
        String artist;
        String etc;
        String actor;
        String director;
        String author;
        String isbn;
        String category;

    }

    @Builder
    @Getter
    @Setter
    public static class LikeItem {
        Boolean isliked;

    }
    }
