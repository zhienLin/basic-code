package www.itheima.demo;

public class StuLogin {
    private String name;
    private String password;
    private String idnumber;
    private String phonenumber;

    public StuLogin() {
    }

    public StuLogin(String name, String password, String idnumber, String phonenumber) {
        this.name = name;
        this.password = password;
        this.idnumber = idnumber;
        this.phonenumber = phonenumber;
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
     * @return idnumber
     */
    public String getIdnumber() {
        return idnumber;
    }

    /**
     * 设置
     * @param idnumber
     */
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    /**
     * 获取
     * @return phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * 设置
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String toString() {
        return "StuLogin{name = " + name + ", password = " + password + ", idnumber = " + idnumber + ", phonenumber = " + phonenumber + "}";
    }
}


