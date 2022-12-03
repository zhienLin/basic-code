package www.itheima.demo.a03staticdemo3;

import java.util.ArrayList;

public class ToolMax {
    private ToolMax() {
    }

    public static int getMaxAge(ArrayList<Student> list) {
        int ageMax = list.get(0).getAge();
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i).getAge();//这种方法避免了方法的反复调用，提高了代码的运行效率。
            if (ageMax < temp)
                ageMax = temp;
        }
        return ageMax;
    }
}
