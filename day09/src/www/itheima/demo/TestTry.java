package www.itheima.demo;

import java.util.Random;

public class TestTry {
    private String name;
    private int blood;
    private char gender;
    private String appearance;

    String[] boyfaces= {"风流俊雅","气宇轩昂","相貌英俊","五官端正","相貌平平","一塌糊涂","面目狰狞"};
    String[] girlfaces ={"美奂绝伦","沉鱼落雁","婷婷玉立","身材娇好","相貌平平","相貌简陋","惨不忍睹"};
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


    public TestTry() {
    }

    public TestTry(String name, int blood, char gender) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        setAppearance(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(char gender) {
        Random r = new Random();
        if(gender == '女'){
            int index = r.nextInt(girlfaces.length);
            this.appearance = girlfaces[index];
        }else if (gender == '男'){
            int index = r.nextInt(boyfaces.length);
            this.appearance = boyfaces[index];
        }else this.appearance = "天外来物";
    }

    public void beat(TestTry role){
        Random r = new Random();
        //攻击的描述
        int index = r.nextInt(attacks_desc.length);
        System.out.printf(attacks_desc[index],this.name,role.getName());
        System.out.println();

        int hurt = r.nextInt(20)+1;
        int remainblood = role.getBlood() - hurt;
        remainblood =remainblood <= 0? 0:remainblood;
        role.setBlood(remainblood);

        //受伤的描述
        if(remainblood >= 90){
            System.out.printf(injureds_desc[0],role.getName());
        } else if(remainblood < 90 && remainblood >= 80){
            System.out.printf(injureds_desc[1],role.getName());
        } else if(remainblood < 80 && remainblood >= 60){
            System.out.printf(injureds_desc[2],role.getName());
        }else if(remainblood < 60 && remainblood >= 40){
            System.out.printf(injureds_desc[3],role.getName());
        }else if(remainblood < 40 && remainblood >= 30){
            System.out.printf(injureds_desc[4],role.getName());
        }else if(remainblood < 30 && remainblood >= 10){
            System.out.printf(injureds_desc[5],role.getName());
        }else
            System.out.printf(injureds_desc[6],role.getName());
        System.out.println();
        System.out.println();


    }

    public void showInFo(){
        System.out.println("该人物的姓名是："+getName());
        System.out.println("该人物的血量是："+getBlood());
        System.out.println("该人物的性别是："+getGender());
        System.out.println("该人物的长相是："+getAppearance());
    }

}
