/*
1.继承于现有的异常结构:RuntimeException . Exception
2.提供全局常量: serialversionUID，这个是因为以后利用I/O流进行信息传输的时候
可能需要传输对象，两端节要检查是否接收的是相同的对象，这个序列号就是评判标准。


*/
public class CreatException extends RuntimeException{
    static final long serialVersionUID = -7134897190745766939L;
    public CreatException(){}
    public CreatException(String message){
        super(message);
        System.out.println("执行了吗");
    }

}
