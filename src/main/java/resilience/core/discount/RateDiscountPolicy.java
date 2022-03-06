package resilience.core.discount;

import org.springframework.stereotype.Component;
import resilience.core.member.Grade;
import resilience.core.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountRate = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountRate / 100;
        }
        return 0;
    }

}
