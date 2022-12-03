package www.itheima.demo;

import java.util.Random;

public class Role {
    private String name;
    private int blood;

    public Role() {
    }

    public Role(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return blood
     */
    public int getBlood() {
        return blood;
    }

    /**
     * 设置
     *
     * @param blood
     */
    public void setBlood(int blood) {
        this.blood = blood;
    }

    //定义一个方法要去攻击别人 r1.beat(r2);
    public void beat(Role role) {
        //计算造成的伤害
        Random r = new Random();
        int hurt = r.nextInt(20) + 1;
        //计算剩余的血量
        int remainBlood = role.getBlood() - hurt;
        //对剩余血量进行判断
        remainBlood = remainBlood > 0 ? remainBlood : 0;
        //从新修订挨揍的人剩余血量
        role.setBlood(remainBlood);

        System.out.println(this.name + "攻击了" + role.getName() + "，造成了"+hurt+"点的伤害,"
                +role.getName() +"还剩余"+remainBlood+"点血量");

    }


}
