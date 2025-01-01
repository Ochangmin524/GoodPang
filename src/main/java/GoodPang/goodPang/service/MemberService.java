package GoodPang.goodPang.service;

import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //멤버 회원 가입
    public Long Join(Member member) {
        //이미 존재하는 멤버라면 에러 반환
        return 1L;
    }
}
