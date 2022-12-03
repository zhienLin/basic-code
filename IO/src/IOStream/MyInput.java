package IOStream;
/*
    Create a program named MyInput.java: Contain the methods for reading
    int, double, float, boolean, short, byte and String values from
    the keyboard.
    创造一个类似于Scanner的类
*/

import java.io.*;

public class MyInput {
    public static void main(String[] args) throws IOException {
        ScannerCope sc = new ScannerCope(System.in);
        System.out.print("请从键盘进行输入整数：");
        int sInt = sc.nextInt();
        System.out.println(sInt);
        System.out.print("请从键盘进行输入浮点数：");
        double sDouble = sc.nextDouble();
        System.out.println(sDouble);
        System.out.print("请从键盘进行输入布尔值：");
        boolean sBoolean = sc.nextBoolean();
        System.out.println(sBoolean);
        System.out.print("请从键盘进行输入字符串：");
        String s = sc.next();
        System.out.println(s);
    }

    public static <E> void read(E e) {
        System.out.println(e);
    }
}

class ScannerCope{
    private InputStream in;
    private BufferedReader br;
    public ScannerCope() {
    }

    public ScannerCope(InputStream in) {
        this.in = in;
        InputStreamReader isr = new InputStreamReader(in);
         br= new BufferedReader(isr);
    }



    public String toString() {
        try {
            return "ScannerCope{s = " + br.readLine() + "}";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String next() throws IOException {
        return br.readLine();
    }
    public byte nextByte() throws IOException{
        return (byte) Integer.parseInt(br.readLine());
    }
    public short nextShort() throws IOException{
        return (short)Integer.parseInt(br.readLine());
    }
    public int nextInt() throws IOException{
        return Integer.parseInt(br.readLine());
    }
    public float nextFloat() throws IOException{
        return Float.parseFloat(br.readLine());
    }
    public double nextDouble() throws IOException{
        return Double.parseDouble(br.readLine());
    }
    public boolean nextBoolean() throws IOException{
        return Boolean.parseBoolean(br.readLine());
    }


    /**
     * 获取
     * @return in
     */
    public InputStream getIn() {
        return in;
    }

    /**
     * 设置
     * @param in
     */
    public void setIn(InputStream in) {
        this.in = in;
    }


    /**
     * 获取
     * @return br
     */
    public BufferedReader getBr() {
        return br;
    }

    /**
     * 设置
     * @param br
     */
    public void setBr(BufferedReader br) {
        this.br = br;
    }
}