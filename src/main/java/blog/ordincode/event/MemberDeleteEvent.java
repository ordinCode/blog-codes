package blog.ordincode.event;

import org.springframework.context.ApplicationEvent;

public class MemberDeleteEvent extends ApplicationEvent {
    private Long memberId;

    public MemberDeleteEvent(Object source, Long memberId) {
        super(source);
        this.memberId = memberId;
    }

    public Long getMemberId() {
        return memberId;
    }
}
