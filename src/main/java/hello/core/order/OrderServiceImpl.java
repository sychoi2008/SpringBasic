package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // 인터페이스에 대한 의존만 함
    private final MemberRepository memberRepository;
    // 고정 할인 정책
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 아이디로 어떤 회원인지 회원의 정보 전체를 가져옴
        Member member = memberRepository.findById(memberId);
        // order service 입장에서는 "난 할인에 대해서는 모르겠고 discountpolicy 니가 알아서 해줘"
        // 결과만 줘! -> 단일 책임 원칙
        // 최종적으로 할인된 가격을 넘김
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
