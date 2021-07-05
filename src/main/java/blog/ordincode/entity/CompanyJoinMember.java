package blog.ordincode.entity;

import javax.persistence.*;

@Entity
public class CompanyJoinMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_num")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_num")
    private Company company;

    public CompanyJoinMember() {
    }

    public CompanyJoinMember(Member member, Company company) {
        this.member = member;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Company getCompany() {
        return company;
    }
}
