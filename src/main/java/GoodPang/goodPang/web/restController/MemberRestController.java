package GoodPang.goodPang.web.restController;

import GoodPang.goodPang.converter.MemberConverter;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.response.ApiResponse;
import GoodPang.goodPang.service.MemberService;
import GoodPang.goodPang.web.dto.MemberRequestDto;
import GoodPang.goodPang.web.dto.MemberResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberRestController {
    private final MemberService memberService;


    //회원가입
    @PostMapping("/members/signup")
    public ApiResponse<MemberResponseDto.joinResultDTO> signup(@RequestBody @Valid MemberRequestDto.JoinDto request) {
        Member member = memberService.joinMember(request); //회원가입
        //카트 생성 및 멤버 할당
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTo(member));
    }

    //회원 수정
    @PatchMapping("/members/edit")
    public ApiResponse<MemberResponseDto.editResultDTO> edit(@RequestBody @Valid MemberRequestDto.EditDto request) {
        Member editMember = memberService.editMember(request);
        return ApiResponse.onSuccess(MemberConverter.toEditResultDTO(editMember));
    }
}
