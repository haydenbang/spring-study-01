package resilience.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import resilience.core.discount.DiscountPolicy;
import resilience.core.discount.RateDiscountPolicy;
import resilience.core.member.MemberService;
import resilience.core.member.MemberServiceImpl;
import resilience.core.member.MemoryMemberRepository;
import resilience.core.order.OrderService;
import resilience.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
