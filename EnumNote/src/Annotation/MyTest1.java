package Annotation;

import java.lang.annotation.*;

/**
 * @author zzy
 * @date 2022-10-13 11:03
 */
@Inherited
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyTest1 {
    Test1 [] value();
}

class Generic<@Test1 T>{
    public void show() throws @Test1 RuntimeException{
        int a = (@Test1 int)10L;
    }
}