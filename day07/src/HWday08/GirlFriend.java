package HWday08;

public class GirlFriend {
    private String name;
    private int height;
    private int weight;

    public GirlFriend() {
    }

    public GirlFriend(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public void wash(){
        System.out.println("女朋友给我做饭");
    }
    public void cook(){
        System.out.println("女朋友帮我洗衣服");
    }
    public void show(String name,int height,int weight){
        System.out.println("我女朋友叫"+name+",身高"+height+"厘米,体重"+weight+"斤。");
    }


    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * 设置
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "GirlFriend{name = " + name + ", height = " + height + ", weight = " + weight + "}";
    }
}
