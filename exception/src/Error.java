public class Error {
//Error: Java虚拟机无法解决的严重问题。如:JVM系统内部错误、资源耗尽等严重情况。
// 比如:StackOverflowError和OOM。一般不编写针对性的代码进行处理。
public static void main(String[] args) {
    //栈溢出：StackOverflowError
    //main(args); 因为一直在调用这个方法，就一直没有办法停止。
    //堆溢出（OOM）：OutOfMemoryError
    Integer [] arr = new Integer[1024*1024*1024*1024*1024*1024];
}


}
/*
一、异常体系结构
        java.lang.Throwable
               -java.lang. Error:一般不编写针对性的代码进行处理。
               -java.lang.Exception:可以进行异常的处理
                    -编译时异常(checked)
                            l -----IOException
                            l-----FileNotFoundExceptionl
                            l-----classNotFoundException
                    -运行时异常(unchecked)
                            l -- ---Nu11PointerException
                            l- - -ArrayIndexOutOfBoundsException
                            l------ClassCastException
                            l-NumberFormatException
                            l-- InputMismatchExceptioni
                            l--- --ArithmeticException
*/
