package www.itheima1;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 所有****type()的函数，要想查看具体的类型，必须调用getName()的方法。
 * 如果不加getName()的方法，那就是前面带有一个class
 * @author zzy
 * @date 2022-10-17 11:41
 */
public class MethodTest {
    /*@Xxxc
      权限修饰符,返回值类型,方法名(参数类型1形参名1,...) throws XxxException{]
     */
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //1注解
/*            Annotation[] declaredAnnotations = declaredMethod.getDeclaredAnnotations();
            for (int i = 0; i < declaredAnnotations.length; i++) {
                System.out.println(declaredMethod.getName()+declaredAnnotations[i]);
            }*/

/*            //2返回值类型
            String name = declaredMethod.getReturnType().getName();
            System.out.println(name);

            //3方法名
            String nameMethod = declaredMethod.getName();
            System.out.print(nameMethod+"(");

            //4形参列表
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            if(!(parameterTypes.length==0)){
                for (int i = 0; i < parameterTypes.length -1; i++) {
                    System.out.print(parameterTypes[i].getName()+" args_"+i+",");
                }
                System.out.print(parameterTypes[parameterTypes.length -1].getName()+" args_"+ (parameterTypes.length -1));
            }
            System.out.println(")");*/

            //抛出的异常
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            if (exceptionTypes != null) {
                for (Class<?> exceptionType : exceptionTypes) {
                    System.out.println(exceptionType.getName());
                }

            }


        }

/*        System.out.println("============================================");
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            System.out.println(method.getName()+declaredAnnotations.toString());
            System.out.println("*****************************************");
        }*/
    }

    //运行时类的带泛型的父类
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    //运行时类的带泛型的父类的泛型
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        //强制转换
        ParameterizedType pt = (ParameterizedType)genericSuperclass;
        //获取泛型的类型
        Type[] actualTypeArguments = pt.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument.getTypeName());
        }
    }


}