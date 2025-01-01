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

}
