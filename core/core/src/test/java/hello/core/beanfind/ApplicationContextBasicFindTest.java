package hello.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    //스프링 컨테이너, ApplicationContext 인터페이스의 구현체
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByName(){
        //MemberService클래스의 memeberService라는 이름을 가진 Bean 찾기
        MemberService memberService = ac.getBean("memberService",MemberService.class);

        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass()  = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }@Test
    @DisplayName("구체 타입으로 조회")
    void findByType2(){
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findByNameX(){
        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxxx",MemberService.class));
        //람다구문에서 왼쪽 에러가 터져야 성공임
    }
}
