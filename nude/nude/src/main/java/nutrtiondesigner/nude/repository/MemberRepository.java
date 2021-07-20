package nutrtiondesigner.nude.repository;

import nutrtiondesigner.nude.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
