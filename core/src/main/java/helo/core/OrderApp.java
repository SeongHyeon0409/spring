package helo.core;

import helo.core.member.Grade;
import helo.core.member.Member;
import helo.core.member.MemberService;
import helo.core.member.MemberServiceImpl;
import helo.core.order.Order;
import helo.core.order.OrderService;
import helo.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
