package helo.core;

import helo.core.discount.DiscountPolicy;
import helo.core.discount.FixDiscountPolicy;
import helo.core.discount.RateDiscountPolicy;
import helo.core.member.*;
import helo.core.order.OrderService;
import helo.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
