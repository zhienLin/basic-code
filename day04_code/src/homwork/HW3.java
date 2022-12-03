package homwork;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

public class HW3 {
    public static void main(String[] args) {
        /*某小伙想定一份外卖，商家的优惠方式如下：
        鱼香肉丝单点24元，油炸花生米单点8元，米饭单点3元。订单满30元8折优惠。
        鱼香肉丝优惠价16元，但是优惠价和折扣不能同时使用。
        那么这个小伙要点这三样东西，最少要花多少钱？*/

        /*double plan1, plan2;
        double compare = 24 + 8 + 3;
        if (compare >= 30)
            plan1 = compare * 0.8;
        else
            plan1 = compare;

        plan2 = 16 + 8 + 3;

        if(plan1 > plan2)
            System.out.println("选择优惠方案点餐花费钱数最少，最少为："+plan2);
        else
            System.out.println("选择折扣方案点餐花费钱数最少，最少为："+plan1);
*/
        double plan1, plan2, result;

        plan1 = (30 + 8 + 3) > 30 ? (30 + 8 + 3)*0.8 : 30 + 8 + 3;
        plan2 = 16 + 8 + 3;
        result = plan1 > plan2 ? plan2 : plan1;
        System.out.println("点餐花费钱数最少为："+result);




    }
}
