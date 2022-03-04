package resilience.core.discount;

import resilience.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
