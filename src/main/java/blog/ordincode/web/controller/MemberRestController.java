package blog.ordincode.web.controller;

import blog.ordincode.common.response.CustomResponse;
import blog.ordincode.web.dto.LoginDto;
import blog.ordincode.web.dto.MemberDto;
import blog.ordincode.web.exception.MemberException;
import blog.ordincode.web.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {
    private final MemberService memberService;

    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member")
    public CustomResponse<Void> join(@RequestBody MemberDto memberDto) {
        memberService.join(memberDto);
        return CustomResponse.empty();
    }

    @PostMapping("/login")
    public CustomResponse<LoginDto> login(@RequestBody LoginDto loginDto) {
        LoginDto loginSuccessDto = memberService.login(loginDto);
        return CustomResponse.of(loginSuccessDto);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MemberException.class)
    public CustomResponse<Void> MemberException(MemberException e) {
        return CustomResponse.error(e.getMessage());
    }
}
