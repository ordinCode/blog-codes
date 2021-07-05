package blog.ordincode;

import blog.ordincode.entity.Company;
import blog.ordincode.entity.CompanyJoinMember;
import blog.ordincode.entity.Member;
import blog.ordincode.repository.CompanyJoinMemberRepository;
import blog.ordincode.repository.CompanyRepository;
import blog.ordincode.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
class OrdincodeApplicationTests {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyJoinMemberRepository companyJoinMemberRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void contextLoads() {
    }

    @Transactional
    @DisplayName("Name")
    @Test
    void name() {
        Company company = companyRepository.save(new Company("company"));
//        Member member = memberRepository.save(new Member("member"));
        Member member2 = memberRepository.save(new Member("member2"));

//        member.joinCompany(company);

        CompanyJoinMember companyJoinMember = companyJoinMemberRepository.save(new CompanyJoinMember(member2, company));
        member2.requestJoinCompany(companyJoinMember);
        entityManager.flush();

//        company.getMembers().remove(0);
//        member.leaveCompany();
//        companyRepository.deleteAll();
        memberRepository.delete(member2);
        entityManager.flush();

    }
}
