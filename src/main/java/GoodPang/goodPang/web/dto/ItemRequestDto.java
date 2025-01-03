package GoodPang.goodPang.web.dto;


import GoodPang.goodPang.domain.enums.Category;
import lombok.Getter;
import lombok.Setter;

public class ItemRequestDto {

    @Getter
    @Setter
    public static class AddItemDto {
        String name;
        int price;
        int stockQuantity;
        Category category;
        String information;
        String artist;
        String etc;
        String author;
        String isbn;
        String director;
        String actor;

    }
}

