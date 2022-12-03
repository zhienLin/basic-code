package www.itheima1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zzy
 * @date 2022-10-17 11:44
 */
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)//必须是运行时的时候，才可以被反射获取
public @interface MyAnnotation {
    String[] value() default "world";
}
