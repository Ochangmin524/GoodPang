package GoodPang.goodPang.api.dto;

import GoodPang.goodPang.domain.member.Address;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class MemberResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    //회원 가입 완료 후, 보내줄것.
    public static class JoinResultDTO {
        Long memberId; //생성된 멤버의 아이디
        LocalDateTime createdAt; //멤버가 생성된 시점
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EditResultDTO {
        Long memberId;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetMemberResultDTO {
        Long memberId;
        String memberName;
        String loginId;
        Address address;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetAllMemberResultDTO {
        Long numOfMembers;
        List<GetMemberResultDTO> members;
    }
}
