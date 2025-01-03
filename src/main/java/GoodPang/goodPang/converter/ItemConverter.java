package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.enums.Category;
import GoodPang.goodPang.domain.item.Album;
import GoodPang.goodPang.domain.item.Book;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.item.Movie;
import GoodPang.goodPang.web.dto.ItemRequestDto;
import GoodPang.goodPang.web.dto.ItemResponseDto;

import java.util.ArrayList;

public class ItemConverter {

    public static ItemResponseDto.AddResultDto toAddResultDTO(Item item) {
        return ItemResponseDto.AddResultDto.builder()
                .itemID(item.getId())
                .build();
    }







    public static Item toItem(ItemRequestDto.AddItemDto request) {
        //공통부분 build
        return createItem(request);
    }

    private static Item createItem(ItemRequestDto.AddItemDto request) {
        if (request.getCategory() == Category.ALBUM) {
            return Album.builder()
                    .price(request.getPrice())
                    .name(request.getName())
                    .stockQuantity(request.getStockQuantity())
                    .category(request.getCategory())
                    .information(request.getInformation())
                    .imageFiles(new ArrayList<>())
                    .artist(request.getArtist())
                    .etc(request.getEtc())
                    .build();
        } else if (request.getCategory() == Category.MOVIE) {
            return Movie.builder()
                    .price(request.getPrice())
                    .name(request.getName())
                    .stockQuantity(request.getStockQuantity())
                    .category(request.getCategory())
                    .information(request.getInformation())
                    .imageFiles(new ArrayList<>())
                    .director(request.getDirector())
                    .actor(request.getActor())
                    .build();
        } else if (request.getCategory() == Category.BOOK) {
            return Book.builder()
                    .price(request.getPrice())
                    .name(request.getName())
                    .stockQuantity(request.getStockQuantity())
                    .category(request.getCategory())
                    .information(request.getInformation())
                    .imageFiles(new ArrayList<>())
                    .author(request.getAuthor())
                    .isbn(request.getIsbn())
                    .build();
        }

        return null;
    }

}
