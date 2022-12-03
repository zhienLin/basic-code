package www.itheima.demo;

import java.util.Random;

public class ReRole {

    //成员变量的定义
    private String name;
    private int blood;
    private char gender;
    private String appearance;
///=====================================================================================================

    //所用数组的声明
    String[] boyappearance = {"风流俊雅", "气宇轩昂", "相貌英俊", "五官端正", "相貌平平", "一塌糊涂", "面目狰狞"};
    String[] girlappearance = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平", "相貌简陋", "惨不忍睹"};

    //attack 攻击描述：
    String[] attacks_desc={
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };

    //injured 受伤描述：
    String[] injureds_desc={
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"
    };
//===================================================================================================================


    public ReRole() {
    }

    public ReRole(String name, int blood, char gender) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        //长相是随机的长相
        setAppearance(gender);
    }
//===================================================================================================================




    //获取
    public String getName() {
        return name;
    }
    public int getBlood() { return blood; }
    public char getGender() { return gender; }
    public String getAppearance() { return appearance; }

    //设置
    public void setName(String name) { this.name = name; }
    public void setGender(char gender) { this.gender = gender; }
    public void setBlood(int blood) { this.blood = blood; }
    public void setAppearance(char gender) {
        Random r = new Random();
        if (gender == '女') {
            int index = r.nextInt(girlappearance.length);
            this.appearance = girlappearance[index];

        } else if (gender == '男') {
            int index = r.nextInt(boyappearance.length);
            this.appearance = boyappearance[index];

        } else {
            this.appearance = "天外来物";
        }
    }//这里的设置不同于参数传递，而是随机获取的，可以展开看看，对开拓思路有帮助。
                                                // 在设置里面随机，构造的时候直接调用

//===================================================================================================================


    //定义一个方法要去攻击别人 r1.beat(r2);
    public void beat(ReRole role) {
        //随机生成一个招数
        Random r = new Random();
        int index = r.nextInt(attacks_desc.length);
        String Kungfu = attacks_desc[index];
        //输出一个攻击的效果
        System.out.printf(Kungfu,this.getName(),role.getName());
        System.out.println();

        //计算造成的伤害
        int hurt = r.nextInt(20) + 1;
        //计算剩余的血量
        int remainBlood = role.getBlood() - hurt;
        //对剩余血量进行判断
        remainBlood = remainBlood > 0 ? remainBlood : 0;
        //从新修订挨揍的人剩余血量
        role.setBlood(remainBlood);

        //受伤的描述，根据人物的剩余血量，来做一个判断
        //大于90,1索引的描述
        //80~90,2索引的描述
        //70~80,3索引的描述
        //50~70,4索引的描述
        //30~50,5索引的描述
        //10~30,6索引的描述
        //0~10,7索引的描述

        if(remainBlood >= 90)
            System.out.printf(injureds_desc[0],role.getName());
        else if(remainBlood >= 80 && remainBlood <90)
            System.out.printf(injureds_desc[1],role.getName());
        else if(remainBlood >= 70 && remainBlood <80)
            System.out.printf(injureds_desc[2],role.getName());
        else if(remainBlood >= 50 && remainBlood <70)
            System.out.printf(injureds_desc[3],role.getName());
        else if(remainBlood >= 30 && remainBlood <50)
            System.out.printf(injureds_desc[4],role.getName());
        else if(remainBlood >= 10 && remainBlood <30)
            System.out.printf(injureds_desc[5],role.getName());
        else
            System.out.printf(injureds_desc[6],role.getName());
        System.out.println();
        System.out.println();


    }
    //输出人物信息
    public void ShowInFo() {
        System.out.println("姓名为：" + getName());
        System.out.println("血量为：" + getBlood());
        System.out.println("性别为：" + getGender());
        System.out.println("长相为：" + getAppearance());
    }


}
