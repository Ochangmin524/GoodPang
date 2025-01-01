package GoodPang.goodPang.service;

import GoodPang.goodPang.converter.MemberConverter;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.repository.MemberRepository;
import GoodPang.goodPang.response.exception.handler.MemberHandler;
import GoodPang.goodPang.response.fail.ErrorStatus;
import GoodPang.goodPang.web.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    //멤버 회원 가입
    public Member joinMember(MemberRequestDto.JoinDto request) {
        //로그인 아이디 중복 여부
        if (isLoginIdDuplicated(request.getLoginId())) {
            throw new MemberHandler(ErrorStatus._DUPLICATED_LOGIN_ID);
        }
        //멤버 생성
        Member member = MemberConverter.toMember(request);
        return memberRepository.save(member); //저장
    }
    //로그인 아이디 중복 여부 확인
    //중복되면 true 반환
    private boolean isLoginIdDuplicated(String loginId) {
        Optional<Member> findMember = memberRepository.findByLoginId(loginId);
        if (findMember.isEmpty()) { //findMember가 null -> 중복되지 않음!
            return false;
        }
        return true;
    }

}
