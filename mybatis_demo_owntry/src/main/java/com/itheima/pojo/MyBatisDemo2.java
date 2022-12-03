package com.itheima.pojo;

import com.itheima.mapper.userMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Mapper代理开发
 * @author zzy
 * @date 2022-11-08 21:44
 */
public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {

        //1加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取SqlSessionFactory的对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3获取UserMapper的代理对象,解决了硬编码的问题。
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);

        //4释放资源
        sqlSession.close();

     /*
     亲爱的仙女，晚上好。
           每一天从睁开眼开始，想念你的程度都会随着时间的推移而累加。尤其是遇到阳光明媚的午后或者有月亮的晚上，总是会给这份
        思念的厚度增加一点;或者恰巧碰到了什么好听的句子或者诗词，总会想着，"啊，原来我的仙女正在疯狂的和这些美好但是又深奥的
        东西打交道"。天气又慢慢开始冷了，不知道你最近是在家还是开启了自习室的两点一线的生活呢，不管那种，都祈祷着今年吉林的冬
        天不会太冷，稍稍暖和一些，这样我的仙女就可以穿相对漂亮一点保暖为辅的鞋子（丝毫没有含沙射影的意思）。
            我的眼眶又开始湿润了，如果此刻你做在我的对面，我一定是没办法忍住不哭的。做题的时候不要咬嘴了，会咬破的，这样就没
        办法吃热热的东西了。仙女，最后这段冲刺的日子，要稳住啊，不慌不忙也不丧气，我一直相信你，也一定要相信我的相信。虽然没
        办法跟你一起，但是根据量子力学的原理，你在学习的时候我也会有感应的，算是变相的相互陪伴啦~。陪伴很关键，这点很重要，
        现在想想是你的存在才是我大学时代里的定心丸和规律剂。虽然我们现在没有时空上的陪伴，但是你我都在做着相同类型的事情，经
        历着由它带来的酸甜苦辣，这又怎么能不算陪伴呢？毕竟我们有过那么多日日陪伴的日子。所以啊，仙女再坚持一下下，很快的，40
        多天很快就过去啦~
            期待着再会
                                                                                              ---滋榆 2022年11月9号晚8点
     */



    }
}
