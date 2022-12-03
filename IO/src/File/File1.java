package File;
/*
1. File类的一个对象，代表一个文件或一个文件目录(俗称:文件夹)
2. FiLe类声明在java.io包下
3.File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法,
并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点".

可以这样理解：文件和内存是独立的两个空间，只是查看，不对文件进行别的操作的时候，
用不到内存和文件的链接，但是一旦需要进行两者之间的信息交流，就必须使用I/O流。
 */


import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class File1 {
    //构造器构造的方法，文件在硬盘中不一定是存在的
    /*1.如何创建File的实例（共有3种形式）

    2.绝对路径
      相对路径：在idel当中，如果大家开发使用JUnit中的单元测试方法测试，那么相对路径是在Module下的
               如果使用main(),那么相对路径是在Project下的
               在eclipse当中，无论是单元测试还是main()方法，相对路径都是在project下的。

               如果我们在编写程序的时候，用的是main()的方法，那么文件如果定义在module下的话，
               在读取文件的时候会报FileNotFound的错。


    3.路径分隔符： Windows：\\ unix： /
    */
    @Test
    public void st1(){
        //1，第一种构造形式：是确定的文件
        File file1 = new File("hello.txt");
        File file2 = new File("F:\\JAVA\\basic_code\\IO\\hello.txt");

        //2，是一个文件的目录，有一个父类的文件路径，还有一个子类的文件的路径，两个都是字符串的形式。
        File file3 = new File("F:\\JAVA","basic_code\\IO");
        System.out.println(file3);

        //3.第一个参数是一个File类型的，后面是一个具体的文件名。
        File file4 = new File(file3,"xixi.tet");
        //再file3的这个路径下的一个文件名。
        System.out.println(file4);
    }

    /*
    public String getAbsolutePath():获取绝对路径
    pablic string getPath() :获取路径
    public string getName() :获取名称
    public string getParent():获取上层文件目录路径。若无，返回nuLl
    public long length():获取文件长度（即:字节数)。不能获取目录的长度。
    public long lastModified():获取最后一尔的修改时间，毫秒值
    public string[] list():获取指定目录下的所有文件或者文件目录的名称数组
    public File[] listFiles() :获取指定目录下的所有文件或者文件目录的File数组
    public boolean renameTo(File dest):把文件重命名为指定的文件路径。
    */
    @Test
    public void test2(){
        File file5 = new File("hello1.txt");
        File file6 = new File("F:\\JAVA\\basic_note\\he1.txt");
        File file3 = new File("F:\\JAVA","basic_code\\IO");
        //绝对路径都是可以获取到的，哪怕定义的时候是以相对路径的形式。
        System.out.println(file5.getAbsolutePath());
        //获取的就是定义该文件的路径类型
        System.out.println(file5.getPath());
        System.out.println(file5.getName());
        //获取上层文件目录路径。若构建的时候是相对路径的形式，就没有上级路径，但是如果是绝对路径的形式，上级路径就在最后定义的那一级路径的上面
        System.out.println(file3.getParent());
        System.out.println(file6.getParent());
        //public long length():获取文件长度（即:字节数)。不能获取目录的长度。
        System.out.println(file5.length());
        //long lastModified():获取最后一尔的修改时间，毫秒值
        System.out.println(new Date(file5.lastModified()));

        //public string[] list():获取指定目录下的所有文件或者文件目录的名称数组
        File file7 = new File("F:\\JAVA\\basic_code");
        String[] list = file7.list();
        for (String s : list) {
            System.out.println(s);
        }

        //public File[] listFiles() :获取指定目录下的所有文件或者文件目录的File数组
        //这个方法的好处就是不仅可以查看该目录下的文件有哪些，还可以通过控制太输出，直接点进去看。
        File[] files = file7.listFiles();
        for (File file : files) {
            System.out.println(file);
        }

        //public boolean renameTo(File dest):把文件重命名为指定的文件路径。
        //比如: fiLe1.renameTo(fiLe2)为例:
        //要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
        //这个可以实现文件的快速转移，就是“嗖”的一下就可以把某个路径的文件转移到另外一个文件夹下
        File transFlie = new File("F:\\JAVA\\basic_note\\NewHello.txt");
        transFlie.renameTo(file5);


    }

    //判断的一些功能
    /*
        public boolean isDirectory():判断是否是文件目录
        public boolean isFile() :判断是否是文件
        public booLean exists() :判断是否存在
        public booLean canRead( ) :判断是否可读
        public booLean canWrite() :判断是否可写
        public boolean isHidden() :判断是否隐藏*/
    @Test
    public void test3(){
        File f1 = new File("hello1.txt");
        System.out.println(f1.isDirectory());//false 是一个文件，并非一个目录
        System.out.println(f1.isFile());
        System.out.println(f1.exists());
        System.out.println(f1.canRead());
        System.out.println(f1.canWrite());
        System.out.println(f1.isHidden());

        System.out.println("=============================");

        File f2 = new File("F:\\JAVA","basic_code\\IO");
        System.out.println(f2.isDirectory());
        System.out.println(f2.isFile());//false 是一个目录，并非一个文件
        System.out.println(f2.exists());//先去判断在不在，然后再去操作
        System.out.println(f2.canRead());
        System.out.println(f2.canWrite());
        System.out.println(f2.isHidden());

    }

   //File类的创建的功能(在硬盘中创建对应的文件或者文件夹)
    /*
    public boolean createNewFile() :创建文件。若文件存在，则不创建，返回faLse
    pblic boolean mkdir():创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层不存在，也不创建
    public boolean mkdirs() :创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，连带上层目录一起创建。
     */
   @Test
   public void test4() throws IOException {
       File file1 = new File("he1.txt");
       if(!file1.exists()){
           boolean newFile = file1.createNewFile();
           System.out.println(newFile);
       }

       File file2 = new File("F:\\JAVA\\basic_note\\xixi\\hah");
       boolean mkdir = file2.mkdirs();
       if (mkdir){
           System.out.println(file2);
       }

   }

    //File类的删除的功能
    /*
    删除磁盘中的文件或文件目录
    public boolean delete():删除文件或者文件夹
    删除注意事项:Java中的删除不走回收站。
    特别需要注意的一点是:如果想要删除的文件有子文件，用delete()根本删除不了，
    如果想要删除成功，就必须一层层进行遍历去逐步删除。
    */
    @Test
    public void test5(){
        File file2 = new File("F:\\JAVA\\basic_note\\xixi");
        boolean mkdir = file2.mkdirs();
        int a = 1;
        if(a==1)
        file2.delete();
    }










































}
