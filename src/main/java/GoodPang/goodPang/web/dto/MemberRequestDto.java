package GoodPang.goodPang.web.dto;

import GoodPang.goodPang.domain.member.Address;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;

public class MemberRequestDto {
    @Getter
    @Setter
    public static class JoinDto {
        String name;
        Address address;
        String loginId;
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
}
