package DeathLocked;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author zzy
 * @date 2022-10-10 21:26
 */
public class LazyUpgrade {
    public static void main(String[] args) {
        Bank instance1 = Bank.getInstance();
        System.out.println(instance1);
        Bank instance2 = Bank.getInstance();
        System.out.println(instance2);
    }
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static  Bank getInstance() {//这里面默认是当前类的.class,也就是当前类是一个类，那么
        //当前类的类也是一个类。可以这样理解：很多东西都有概念，那么概念这个词本身也有一个概念。

        //效率较低，因为以后每一个进来的线程都需要一个接一个地等着去判断
/*        synchronized(Bank.class){
            if (instance == null) {
                instance = new Bank();
            }
            return instance;
        }
    }*/


    //效率较高
    if (instance == null) {
        synchronized (Bank.class) {
            if (instance == null)//还是在需要判断一次，避免上面判断的阻塞情况地发生
                instance = new Bank();
        }
    }
    return instance;
}


}