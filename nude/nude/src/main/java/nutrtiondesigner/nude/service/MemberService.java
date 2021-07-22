package nutrtiondesigner.nude.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nutrtiondesigner.nude.model.domain.Member;
import nutrtiondesigner.nude.model.form.SignUpForm;
import nutrtiondesigner.nude.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signUp(SignUpForm signUpForm) {
        Member member = new Member(signUpForm);
        memberRepository.save(member);
    }

    public Member signIn(Long id, String pw){
        return memberRepository.findById(id)
                .filter(m -> m.getPassword().equals(pw))
                .orElse(null);
    }
}
