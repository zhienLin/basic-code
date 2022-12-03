package com.itheima.web.Mapper;

import com.itheima.web.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zzy
 * @date 2022-11-19 17:45
 */
public interface UserMapper {

    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User selectAll(@Param("username") String username, @Param("password") String password);


    @Select("select * from tb_user where username = #{username}")
    User verify(String username);

    @Insert("insert into tb_user values (6,#{username},#{password},'女',null)")
    void insert(@Param("username") String name, @Param("password") String passsword);


}
