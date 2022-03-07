package resilience.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import resilience.core.annotation.MainDiscountPolicy;
import resilience.core.member.Grade;
import resilience.core.member.Member;

@Component
@MainDiscountPolicy
//@Primary
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
