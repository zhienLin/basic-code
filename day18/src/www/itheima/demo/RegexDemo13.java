package www.itheima.demo;
//这一部分主要是用于练习捕获分组的$号的使用，主要是用在分组的外面
// \\组号
public class RegexDemo13 {
    public static void main(String[] args) {
        /*
       把“我要学学编编编编程程程程”，替换为“我要学编程”
         */
        String str = "我要学学编编编编程程程程";
        //(.)把车重复内容的第一个字符看作一组
        //$1就是再次把第一组的 东西拿出来用一下
        String replace = str.replaceAll("(.)\\1+", "$1");//表示把前面的第一组的东西拿出来再用一下
        System.out.println(replace);
    }
}


//非捕获分组：不需要再使用分组里面的数据
//(?:) (?=) (:!) 用到的最多的就是(?:)冒号后面就是包括后面的内容