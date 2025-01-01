package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.web.dto.MemberRequestDto;
import GoodPang.goodPang.web.dto.MemberResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    //회원가입 결과 생성
    public static MemberResponseDto.joinResultDTO toJoinResultDTo(Member member) {
        return MemberResponseDto.joinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }




    public static Member toMember(MemberRequestDto.JoinDto request) {
        return Member.builder()
                .name(request.getName())
                .address(request.getAddress())
                .loginId(request.getLoginId())
                .password(request.getPassword())
                .likedItems(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }
}
