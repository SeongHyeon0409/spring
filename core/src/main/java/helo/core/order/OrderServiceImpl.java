package helo.core.order;

import helo.core.discount.DiscountPolicy;
import helo.core.discount.FixDiscountPolicy;
import helo.core.discount.RateDiscountPolicy;
import helo.core.member.Member;
import helo.core.member.MemberRepository;
import helo.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
