package resilience.core.binfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import resilience.core.AppConfig;

class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        String[] binDefinitionNames = ac.getBeanDefinitionNames();
        for (String binDefinitionName : binDefinitionNames) {
            Object bean = ac.getBean(binDefinitionName);
            System.out.println("binDefinitionName = " + binDefinitionName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("어플리케이션 빈 출력")
    void findAllApplicationBean() {
        String[] binDefinitionNames = ac.getBeanDefinitionNames();
        for (String binDefinitionName : binDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(binDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(binDefinitionName);
                System.out.println("binDefinitionName = " + binDefinitionName + " object = " + bean);
            }
        }
    }

}
