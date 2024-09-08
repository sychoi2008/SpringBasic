package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();

        // AppConfig에 있는 환경설정 정보를 가지고 그 안에 있는 객체들을 스프링 컨테이너에 객체를 생성하여 집어넣어서 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 기본적으로 Bean에 메소드 이름으로 등록이 됨 + 반환타입
        // 스프링 컨테이너에 key-value(메소드 이름 - return 값) 형태로 등록됨
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = "+findMember.getName());
    }
}
