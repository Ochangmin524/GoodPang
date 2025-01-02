package GoodPang.goodPang.web.dto;

import GoodPang.goodPang.domain.member.Address;
import lombok.*;

import java.time.LocalDateTime;

public class MemberResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    //회원 가입 완료 후, 보내줄것.
    public static class joinResultDTO {
        Long memberId; //생성된 멤버의 아이디
        LocalDateTime createdAt; //멤버가 생성된 시점
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class editResultDTO {
        Long memberId;
    }
}
