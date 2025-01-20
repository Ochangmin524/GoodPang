package GoodPang.goodPang.web.controller.members;

import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.service.MemberService;
import GoodPang.goodPang.web.dto.MemberRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    //회원가입 폼 요청
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("memberForm", new MemberRequestDto.JoinDto());
        return "members/signup";
    }
    //회원가입 post 요청
    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("memberForm") MemberRequestDto.JoinDto request, Model model) {
        try {
            Member member = memberService.joinMember(request);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            return "members/signup";
        }
    }
}
