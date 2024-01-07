package noobProject.hellospring.service;

import java.util.List;
import java.util.Optional;
import noobProject.hellospring.domain.Member;
import noobProject.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class MemberService {
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(member1 ->{
            throw new IllegalStateException("이미 존재하는 회원이오..");
        } );
    }
    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers(){
        return  memberRepository.findAll();
    }
    public Optional<Member>findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
