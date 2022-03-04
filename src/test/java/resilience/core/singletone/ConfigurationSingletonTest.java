package resilience.core.singletone;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import resilience.core.AppConfig;
import resilience.core.member.MemberRepository;
import resilience.core.member.MemberServiceImpl;
import resilience.core.order.OrderServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {
    @Test
    void configurationTetst() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository mr1 = memberService.getMemberRepository();
        MemberRepository or1 = orderService.getMemberRepository();

        System.out.println("or1 = " + or1);
        System.out.println("mr1 = " + mr1);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(mr1).isSameAs(or1);
        assertThat(or1).isSameAs(memberRepository);
    }
    
    @Test
    void configurationDeep() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
    }
}
