package GoodPang.goodPang.api.dto;

import GoodPang.goodPang.domain.member.Address;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class MemberRequestDto {
    @Getter
    @Setter
    public static class JoinDto {
        @NotNull
        String name;
        @NotNull
        Address address;
        @NotNull
        String loginId;
        @NotNull
        String password;

    }


    @Getter
    @Setter
    //멤버 수정 요청 정보 DTO -> 로그인 정보는 수정 불가
    public static class EditDto {
        Long id;
        String name;
        Address address;
    }


    @Getter
    @Setter
    public static class GetMemberDto {
        Long id;
    }
}
