package www.itheima.demo;

public class StringBuilderTest2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        String s1 = sb.append(arr[arr.length - 1]).append("]").toString();
        System.out.println(s1);
    }
}
