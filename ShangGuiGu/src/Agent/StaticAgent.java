package Agent;

/**
 * 应用场景:
 *  安全代理:屏蔽对真实角色的直接访问。
 *  远程代理:通过代理类处理远程方法调用（RMI)
 *  延迟加载:先加载轻量级的代理对象，真正需要再加载真实对象
 * 比如你要开发一个大文档查看软件，大文档中有大的图片，有可能一个图片有100MB，在打开文件时，不可能将所有的图片都显示出来，这样就可以使用代理模式，当需要查看图片时，用proxy来进行大图片的打开。
 * 分类
 *  静态代理（静态定义代理类)
 *  动态代理（动态生成代理类)
 * JDK自带的动态代理，需要反射等知识
 * @author zzy
 * @date 2022-10-17 21:01
 */
public class StaticAgent {
    public static void main(String[] args) {
        Master m = new Master();//被代理类
        Agent a = new Agent(m);//代理类
        a.browse();
    }
}

interface NetWork{
     public void browse();
}


class Master implements NetWork{
    public Master(){}
    @Override
    public void browse() {
        System.out.println("被代理类想要浏览网页");
    }
}

class Agent implements NetWork{
    private NetWork nw;
    //构造一个带有网络的构造器
    public Agent(NetWork nw){
        this.nw = nw;
    }

    public void check(){
        System.out.println("联网之前的检查");
    }


    @Override
    public void browse() {
        check();
        nw.browse();
    }
}