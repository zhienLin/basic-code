package www.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 要想实现动态代理，需要解决的问题?
 *      问题一:如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 *      问题二:当通过代理类的对象调用方法时，如何动态地去调用被代理类中的同名方法。
 * @author zzy
 * @date 2022-10-17 21:30
 */
public class ProxyTest {
    public static void main(String[] args) {
        Master m = new Master();
        NetWork slave = (NetWork) ProxyFactory.getProxyInstance(m);
        slave.browse("谷歌");
    }
}
//1.定义一个接口
interface NetWork{
    void browse(String s);
}

//2.创建被代理类
class Master implements NetWork{
    public Master(){}
    @Override
    public void browse(String s) {
        System.out.println("被代理类想要浏览网页是：" + s);
    }
}

//3构建被代理类的生产工厂
//解决问题一：定义一个代理类的工厂，到时候直接new 该工厂类就可以了
class ProxyFactory{
    public static Object getProxyInstance(Object obj){//被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);


    }
}

//解决问题二
//当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法: invoke()
// 将被代理类要执行的方法a的功能就声明在invoke()中
class MyInvocationHandler implements InvocationHandler{
    private Object obj;//需要被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //proxy其实就是被代理类的对象，method就是被代理类调用的哪个方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        Object invoke = method.invoke(obj, args);
        return invoke;
    }
}
















