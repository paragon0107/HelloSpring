package noobProject.hellospring;

import noobProject.hellospring.repository.JDBCMemberRepository;
import noobProject.hellospring.repository.JDBCTemplateMemberRepository;
import noobProject.hellospring.repository.MemberRepository;
import noobProject.hellospring.repository.MemoryMemberRepository;
import noobProject.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
        //return new JDBCMemberRepository(dataSource);
        return new JDBCTemplateMemberRepository(dataSource);
    }
}
