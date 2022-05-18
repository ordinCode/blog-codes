package blog.ordincode.service;

import blog.ordincode.entity.Member;
import blog.ordincode.entity.Subscribe;
import blog.ordincode.repository.MemberRepository;
import blog.ordincode.repository.SubscribeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private SubscribeRepository subscribeRepository;

    @Test
    void name() throws InterruptedException {
        //given
        Member member = memberRepository.save(new Member("name"));
        subscribeRepository.save(new Subscribe(member.getId()));

        //when
        memberService.deleteMember(member.getId());

        //then
        Thread.sleep(1000);
        Assertions.assertThat(subscribeRepository.findAll()).isEmpty();
    }
}