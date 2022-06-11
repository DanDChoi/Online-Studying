package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {


    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(singletoneBean.class);
        singletoneBean singletoneBean1 = ac.getBean(singletoneBean.class);
        singletoneBean singletoneBean2 = ac.getBean(singletoneBean.class);
        System.out.println("singletoneBean1 = " + singletoneBean1);
        System.out.println("singletoneBean2 = " + singletoneBean2);
        assertThat(singletoneBean1).isSameAs(singletoneBean2);
        ac.close();
    }

    @Scope("singleton") //default값이 singleton이기 때문에 ("singleton")생략 가능
    static class singletoneBean{
        @PostConstruct
        public void init(){
            System.out.println("singletoneBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("singletoneBean.destroy");
        }
    }

}
