package resilience.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {
    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find pb1");
        PrototypeBean pb1 = ac.getBean(PrototypeBean.class);
        System.out.println("find pb2");
        PrototypeBean pb2 = ac.getBean(PrototypeBean.class);
        System.out.println("pb1 = " + pb1);
        System.out.println("pb2 = " + pb2);

        assertThat(pb1).isNotSameAs(pb2);

        ac.close();
        pb1.close();
        pb2.close();
    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void close() {
            System.out.println("PrototypeBean.close");
        }
    }
}
