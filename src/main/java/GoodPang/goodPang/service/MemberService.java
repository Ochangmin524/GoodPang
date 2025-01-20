package GoodPang.goodPang.service;

import GoodPang.goodPang.converter.CartConverter;
import GoodPang.goodPang.converter.MemberConverter;
import GoodPang.goodPang.domain.cart.Cart;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.repository.CartRepository;
import GoodPang.goodPang.repository.MemberRepository;
import GoodPang.goodPang.response.exception.handler.MemberHandler;
import GoodPang.goodPang.response.fail.ErrorStatus;
import GoodPang.goodPang.web.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;
    //config 에서 설정했던 BCryptPa....는 passwordEncoder 인터페이스의 구현체이다.
    private final PasswordEncoder passwordEncode;

    //멤버 회원 가입
    @Transactional
    public Member joinMember(MemberRequestDto.JoinDto request) {
        //로그인 아이디 중복 여부
        if (isLoginIdDuplicated(request.getLoginId())) {
            throw new MemberHandler(ErrorStatus._DUPLICATED_LOGIN_ID);
        }
        //멤버 생성
        Member member = MemberConverter.toMember(request);
        member.encodePassword(passwordEncode.encode(request.getPassword()));
        //장바구니 생성
        Cart cart = CartConverter.toCart(member);

        //연관관계 매핑
        member.setCart(cart);

        cartRepository.save(cart);
        return memberRepository.save(member);

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


    //멤버 수정
    //더티체킹으로 수정이므로, save 하지 않아도 된다.
    @Transactional
    public Member editMember(MemberRequestDto.EditDto request) {
        //멤버 조회
        Member findMember = memberRepository.findById(request.getId()).orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));
        //조회한 멤버 수정
        Member editMember = findMember.editMember(request.getName(), request.getAddress());
        return editMember;
    }

    @Transactional(readOnly = true)
    public Member getMember(Long loginId) {
        return   memberRepository.findById(loginId).orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }
}
