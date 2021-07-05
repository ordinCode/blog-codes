package blog.ordincode.repository;

import blog.ordincode.entity.CompanyJoinMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyJoinMemberRepository extends JpaRepository<CompanyJoinMember, Long> {
}
