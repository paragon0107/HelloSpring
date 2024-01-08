package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {

    @Test
    void test(){
        AnnotationConfigApplicationContext ac0 = new AnnotationConfigApplicationContext(AutoAppConfig.class,
                AppConfig.class);

    }


}
