package www.itheima.HW;

public class Happy {
    private static final String reason = "美食";
    private String behavior;

    public Happy(String behavior) {
        this.behavior = behavior;
    }
    public Happy() {
    }

    public String getBehavior() {
        return behavior;
    }

    public static String getReason() {
        return reason;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}
