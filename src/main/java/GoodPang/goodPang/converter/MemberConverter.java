package GoodPang.goodPang.converter;

import GoodPang.goodPang.domain.enums.MemberRole;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.api.dto.MemberRequestDto;
import GoodPang.goodPang.api.dto.MemberResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    //모든 회원 조회 결과 생성
    public static MemberResponseDto.GetAllMemberResultDTO togetAllMemberResultDTO(List<Member> members) {
        return MemberResponseDto.GetAllMemberResultDTO.builder()
                .numOfMembers((long) members.size())
                .members(toMemberListDto(members))
                .build();

    }

    private static List<MemberResponseDto.GetMemberResultDTO> toMemberListDto(List<Member> members) {
        return members.stream().map(MemberConverter::toGetMemberResponseDto).collect(Collectors.toList());
    }


    //회원 조회 결과 생성
    public static MemberResponseDto.GetMemberResultDTO toGetMemberResponseDto(Member member) {
        return MemberResponseDto.GetMemberResultDTO.builder()
                .memberName(member.getName())
                .address(member.getAddress())
                .memberId(member.getId())
                .loginId(member.getLoginId())
                .build();
    }



    //회원가입 결과 생성
    public static MemberResponseDto.JoinResultDTO toJoinResultDTo(Member member) {
        return MemberResponseDto.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    //회원 수정 결과 생성
    public static MemberResponseDto.EditResultDTO toEditResultDTO(Member editMember) {
        return MemberResponseDto.EditResultDTO.builder()
                .memberId(editMember.getId()).build();
    }


    public static Member toMember(MemberRequestDto.JoinDto request) {
        return Member.builder()
                .name(request.getName())
                .address(request.getAddress())
                .loginId(request.getLoginId())
                .password(request.getPassword())
                .likedItems(new ArrayList<>())
                .orders(new ArrayList<>())
                .role(MemberRole.USER)
                .build();
    }


}
