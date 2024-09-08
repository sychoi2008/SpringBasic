package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    // 테스트가 실행되기 전에 반드시 실행되는 것
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    //MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given : ~것들이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when : 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : ~ 된다
        // 내가 만든 member가 찾아온 member와 같은가?
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
