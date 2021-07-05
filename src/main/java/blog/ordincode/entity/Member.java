package blog.ordincode.entity;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "member_num")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "member", orphanRemoval = true)
    private CompanyJoinMember companyJoinMember;

    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public Member(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public void joinCompany(Company company) {
        this.company = company;
        company.addMember(this);
    }

    public void leaveCompany() {
        this.company = null;
    }

    public void requestJoinCompany(CompanyJoinMember companyJoinMember) {
        this.companyJoinMember = companyJoinMember;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public CompanyJoinMember getCompanyJoinMember() {
        return companyJoinMember;
    }
}
