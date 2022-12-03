package target;

public class JavaBeanUser {
    private String name;
    private String password;
    private String email;
    private int    gender;
    private int    age;

    public JavaBeanUser() {
    }

    public JavaBeanUser(String name, String password, String email, int gender, int age) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;
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
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return gender
     */
    public int getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }


    //快捷键 Alt + Insert, 选择第一个回车, 什么都不选，快捷生成无参构造的方法。
    // 生成带参的，可以按住Shift键不松，在选中最后一个参数。或者按Ctrl + A。
    //快捷键 Alt + Insert,选择第四个，Ctrl + A全选。则生成全部的get和set的方法
    //插件PTG,1秒生成标准的JavaBean File->Settings->Plugins,then click the install.




}
