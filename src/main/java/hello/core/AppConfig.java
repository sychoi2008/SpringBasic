package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    // 어딘가에서 멤버 서비스를 불러다 쓸 것 -> 멤버 서비스의 구현체의 객체가 생성됨.
    // 메모리 멤버 리포지토리가 들어감
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 메소드 명을 보면 역할이 다 드러남
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // Appconfig를 통해 누군가 orderservice를 조회하면, orderserviceImpl이 반환되는데,
    // 거기에 메모리 멤버 리포지토리, 픽스 디스카운트 폴리시가 들어감 
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
