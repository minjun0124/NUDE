package nutrtiondesigner.nude.controller;

import lombok.RequiredArgsConstructor;
import nutrtiondesigner.nude.model.domain.User;
import nutrtiondesigner.nude.model.form.SignUpForm;
import nutrtiondesigner.nude.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    // UserDto 를 받아서 userService 의 signup 메소드를 호출
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody SignUpForm signUpForm) {
        return ResponseEntity.ok(userService.signup(signUpForm));
    }

    // PreAuthorize 활용
    // USER Role 과 ADMIN Role 모두 접근할 수 있다.
    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<User> getMyUserInfo() {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
    }

    // PreAuthorize 활용
    // ADMIN Role 만이 접근할 수 있다.
    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
    }
}