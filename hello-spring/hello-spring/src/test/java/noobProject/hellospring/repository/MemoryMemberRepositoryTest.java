package noobProject.hellospring.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import noobProject.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Mingyu!");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member,result);     이건 junit방식, 아래껀 assertj.core.api방식
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("mingyuSpring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("mingyuSpring2");
        repository.save(member2);

        Member result = repository.findByName("mingyuSpring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);



    }


}
