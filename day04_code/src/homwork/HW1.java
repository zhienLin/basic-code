package homwork;

public class HW1 {
    public static void main(String[] args) {
        //身高是具有遗传性的，子女的身高和父母的身高有一定的关系。假定，父母和子女的身高遗传关系如下：
        //儿子身高（厘米）＝(父亲身高＋母亲身高) ×1.08÷2
        //女儿身高（厘米）＝(父亲身高×0.923＋母亲身高) ÷2
        //现有父亲身高177CM,母亲身高165CM。求子女身高分别预计为多少？

        //定义父母身高以及子女身高的初始化语句
        double dadHeight = 177;
        double momHeight = 165;
        double sonHeight, daughterHeight;

        sonHeight = (dadHeight+momHeight)*1.08/2;
        daughterHeight = (dadHeight * 0.923 + momHeight)/2;
        System.out.println("儿子的身高是:"+sonHeight);
        System.out.println("女儿的身高是:"+daughterHeight);


    }
}
