package GoodPang.goodPang.api.restController;

import GoodPang.goodPang.converter.MemberConverter;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.response.ApiResponse;
import GoodPang.goodPang.service.MemberService;
import GoodPang.goodPang.api.dto.MemberRequestDto;
import GoodPang.goodPang.api.dto.MemberResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberRestController {
    private final MemberService memberService;

    //회원가입
    @PostMapping("/members/signup")
    public ApiResponse<MemberResponseDto.JoinResultDTO> signup(@RequestBody @Valid MemberRequestDto.JoinDto request) {
        Member member = memberService.joinMember(request); //회원가입
        //카트 생성 및 멤버 할당
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTo(member));
    }

    //회원 수정
    @PatchMapping("/members/edit")
    public ApiResponse<MemberResponseDto.EditResultDTO> edit(@RequestBody @Valid MemberRequestDto.EditDto request) {
        Member editMember = memberService.editMember(request);
        return ApiResponse.onSuccess(MemberConverter.toEditResultDTO(editMember));
    }

    //회원 조회
    @GetMapping("/members/{memberId}")
    public ApiResponse<MemberResponseDto.GetMemberResultDTO> getMember(@PathVariable("memberId") Long memberId) {
        Member member = memberService.getMember(memberId);
        return ApiResponse.onSuccess(MemberConverter.toGetMemberResponseDto(member));
    }
    //모든 회원 목록 조회
    @GetMapping("/members/all")
    public ApiResponse<MemberResponseDto.GetAllMemberResultDTO> getAllMember() {
        return ApiResponse.onSuccess(MemberConverter.togetAllMemberResultDTO(memberService.getMembers()));
    }
}
