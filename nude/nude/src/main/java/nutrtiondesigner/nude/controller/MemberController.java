package nutrtiondesigner.nude.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nutrtiondesigner.nude.model.form.SignInForm;
import nutrtiondesigner.nude.model.form.SignUpForm;
import nutrtiondesigner.nude.service.MemberService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    private HttpSession session;

    @PostMapping
    private void signUp(Model model, SignUpForm signUpForm) {
        try {
            memberService.signUp(signUpForm);
            model.addAttribute("msg", "가입이 완료되었습니다. 다시 로그인 해주세요.");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "회원 저장에 실패했습니다.");
        }
    }

}
