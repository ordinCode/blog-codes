package blog.ordincode.service;


import blog.ordincode.event.MemberDeleteEvent;
import blog.ordincode.repository.MemberRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher eventPublisher;

    public MemberService(MemberRepository memberRepository, ApplicationEventPublisher eventPublisher) {
        this.memberRepository = memberRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public void deleteMember(Long memberId) {
        System.out.println("start deleteMember");
        memberRepository.deleteById(memberId);
        eventPublisher.publishEvent(new MemberDeleteEvent(this, memberId));
        System.out.println("end deleteMember");
    }
}
