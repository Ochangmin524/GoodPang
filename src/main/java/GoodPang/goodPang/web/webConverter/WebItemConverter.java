package GoodPang.goodPang.web.webConverter;

import GoodPang.goodPang.domain.enums.Category;
import GoodPang.goodPang.domain.item.Album;
import GoodPang.goodPang.domain.item.Book;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.item.Movie;
import GoodPang.goodPang.web.webDto.webItemDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class WebItemConverter {

    public static List<webItemDto.ItemDto> toItemListDto(Page<Item> items) {
        return items.stream()
                .map(WebItemConverter::toItemDto)
                .collect(Collectors.toList());
    }
    private static webItemDto.ItemDto toItemDto(Item item) {
        return webItemDto.ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .likes(item.getLikes())
                .quantity(item.getStockQuantity())
                .build();
    }

    public static webItemDto.ItemDetailDto toItemDetailDto(Item item) {
        if (item.getCategory() == Category.ALBUM) {
            Album album = (Album) item;
            return getItemDetailDto(item)
                    .etc(album.getEtc())
                    .author(album.getArtist())
                    .build();
        } else if (item.getCategory() == Category.BOOK) {
            Book book = (Book) item;
            return getItemDetailDto(item)
                    .isbn(book.getIsbn())
                    .author(book.getAuthor())
                    .build();
        } else if (item.getCategory() == Category.MOVIE) {
            Movie movie = (Movie) item;
            return getItemDetailDto(item)
                    .actor(movie.getActor())
                    .director(movie.getDirector())
                    .build();
        } else {
            return getItemDetailDto(item).build();
        }

    }

    //아이템 공통 부분 생성 메서드
    private static webItemDto.ItemDetailDto.ItemDetailDtoBuilder getItemDetailDto(Item item) {
        return webItemDto.ItemDetailDto.builder()
                .id(item.getId())
                .price(item.getPrice())
                .quantity(item.getStockQuantity())
                .name(item.getName())
                .category(item.getCategory().name());

    }

    }

