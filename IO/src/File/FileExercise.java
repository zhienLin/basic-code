package File;
/*
    1.利用File构造器，new一个文件目录file
        1)在其中创建多个文件和目录。
        2)编写方法，实现删除file中指定文件的操作。
    2.判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
    3.遍历指定目录所有文件名称，包括子文件目录中的文件。
        拓展1:并计算指定目录占用空间的大小
        拓展2:删除指定文件目录及其下的所有文件
*/

import java.io.File;
import java.io.IOException;

public class FileExercise {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\JAVA\\basic_code\\IO");
        file.createNewFile();
        //创建一个与file同目录下的另外一个文件，文件夹名为“haha.txt”。
        File fileSameLevel = new File(file.getParent(), "haha.txt");
        fileSameLevel.createNewFile();

        String[] list = file.list();
        for (String s : list) {
            if(s.endsWith(".jpg")){
                System.out.println("存在诶");
            }


        }

        File[] files = file.listFiles();
        traverse(file);
    }

    public static void traverse(File f){
        File[] files = f.listFiles();
        for (File file : files) {
            if(file.isDirectory())
                traverse(file);
            else
                System.out.println(file);
        }

    }


}
