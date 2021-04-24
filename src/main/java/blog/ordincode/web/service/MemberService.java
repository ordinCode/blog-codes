package blog.ordincode.web.service;

import blog.ordincode.entity.member.model.Member;
import blog.ordincode.entity.member.repository.MemberRepository;
import blog.ordincode.web.dto.LoginDto;
import blog.ordincode.web.dto.MemberDto;
import blog.ordincode.web.exception.MemberException;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(MemberDto memberDto) {
        memberRepository.findByNickName(memberDto.getNickName())
                .ifPresent(member -> {
                    throw new MemberException("중복된 아이디입니다.");
                });
        Member member = memberDto.toMember();
        memberRepository.save(member);
    }

    public LoginDto login(LoginDto loginDto) {
        Member member = memberRepository.findByNickName(loginDto.getNickName())
                .orElseThrow(() -> new MemberException("아이디를 확인해주세요"));

        try {
            member.validatePassword(loginDto.getPassword());
        } catch (IllegalArgumentException e) {
            throw new MemberException(e.getMessage());
        }

        return new LoginDto("successToken");
    }
}
