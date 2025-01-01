package GoodPang.goodPang.repository;

import GoodPang.goodPang.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
