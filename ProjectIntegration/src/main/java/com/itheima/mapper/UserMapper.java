package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zzy
 * @date 2022-11-23 10:50
 */
public interface UserMapper {

    @Select("select * from tb_user where username=#{username} and password=#{passsword};")
    User login(@Param("username") String  name, @Param("passsword") String passsword);


    @Select("select * from tb_user where username = #{username}")
    User verify(String username);

    @Insert("insert into tb_user values (null,#{username},#{password},'女',null)")
    void insert(@Param("username") String name, @Param("password") String passsword);

}


