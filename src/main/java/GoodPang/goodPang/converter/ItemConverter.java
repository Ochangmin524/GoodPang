package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.enums.Category;
import GoodPang.goodPang.domain.item.Album;
import GoodPang.goodPang.domain.item.Book;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.item.Movie;
import GoodPang.goodPang.api.dto.ItemRequestDto;
import GoodPang.goodPang.api.dto.ItemResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemConverter {






    public static ItemResponseDto.DeleteResultDto toDeleteResultDto(Long itemId) {
        return ItemResponseDto.DeleteResultDto.builder()
                .itemID(itemId)
                .build();
    }

    public static ItemResponseDto.AddResultDto toAddResultDTO(Item item) {
        return ItemResponseDto.AddResultDto.builder()
                .itemID(item.getId())
                .build();
    }


    public static ItemResponseDto.GetAllItemResultDto toGetAllItemResultDTO(List<Item> itemList) {
        return ItemResponseDto.GetAllItemResultDto.builder()
                .numOfItems((long) itemList.size())
                .items(toItemListDto(itemList))
                .build();
    }

    private static List<ItemResponseDto.GetItemDto> toItemListDto(List<Item> itemList) {
        return itemList.stream().map(ItemConverter::toGetItemDTO).collect(Collectors.toList());
    }

    public static ItemResponseDto.GetItemDto toGetItemDTO(Item item) {
        return ItemResponseDto.GetItemDto.builder()
                .price(item.getPrice())
                .likes(item.getLikes())
                .category(item.getCategory())
                .information(item.getInformation())
                .stockQuantity(item.getStockQuantity())
                .itemID(item.getId())
                .name(item.getName())
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
            else return null;
    }

}
