package com.itheima.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonDemo1 {

    public static void main(String[] args) {
        //1. 将Java对象转为JSON字符串
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");

        String jsonstr = JSON.toJSONString(user);
        System.out.println(jsonstr);

        User jsonObject = JSON.parseObject(jsonstr,User.class);
        System.out.println(jsonObject);

    }
}
