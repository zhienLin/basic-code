package Annotation;

import java.lang.annotation.*;

/**
 *注解的使用
 * 1.理解Annotation:
 * >jdk 5.0 新增的功能
 * >Annotation其实就是代码里的特殊标记,这些标记可以在编译,类加载,运行时被读取,
 * 并执行相应的处理。通过使用Annotation,程序员可以在不改变原有逻辑的情况下,
 * 在源文件中嵌入一些补充信息。代码分析工具、开发工具和部署工具可以通过这些
 * 补充信息进行验证或者进行部署。
 *>在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。
 * 在JavaEE/Android中注解占据了更重要的角色，例如用来配置应用程序的任何切面，
 * 代替JavaEE旧版中所遗留的繁冗代码和XML配置等。
 *
 * 2. Annocation的使用示例
 * 示例一:生成文档相关的注解
 * 示例二:在编译时进行格式检查(JDK内置的三个基本注解)
 * @override: 限定重写父类方法,该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类，方法等)已过时。通常是因为所修饰的结构危险或者有更好的选择。
 * @Suppresswarnings: 抑制编译器警告
 * *示例三:跟踪代码依赖性，实现替代配置文件功能
 *
 * 3.如何自定义注解：参照@Suppresswarnings定义
 * >注解声明为:@interface
 * >内部定义成员，通常使用value表示
 * >可以指定成员的默认值，使用defauLt定义
 * >如果自定义注解没有成员,表明是一个标识作用。
 * 如果注解有成员，在使用注解时，需要指明成员的值。
 * 自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
 * 自定义注解通过都会指明两个元注解: Retention、Target
 *
 *4.元注解:对现有的注解进行解释说明的注解
 * Retention:指定所修饰的Annotation的生命周期:SOURCE \CLASS(默认行为)\RUNTIME
 * 只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 * Target:用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 * Documented:表示所修饰的注解在被javadoc解析时，保留下来。因为默认的情况是不保留的
 * Inherited：被它修饰的注解具有继承性
 *
 * 5.通过反射获取信息
 *
 * 6.JDK.8以后的新特性
 * >可重复注解：在Test1上声明@Repeatable，成员值为MyTest1.class
 *              Test1 的Target和Retention等元注解和MyTest1相同。
 * >类型注解：ElementType.TYPE_PARAMETER表示该注解能写在类型变量的声明语句中（如:泛型声明)
 *            ELementType.TYPE_USE表示该注解能写在使用类型的任何语句中。
 *
 * @author zzy
 * @date 2022-10-12 21:36
 */
@Inherited
@Repeatable(MyTest1.class)
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
public @interface Test1 {
    String value() default "hello";
}




