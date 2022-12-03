import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zzy
 * @date 2022-11-10 11:05
 */
public class BrandTest {

    @Test
    public void testSelectAll() throws IOException {
        //1加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取SqlSessionFactory的对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3用Mapper代理的方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

        //4释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        int id = 13;
        //1加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取SqlSessionFactory的对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3用Mapper代理的方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectByIdBrand(id);
        System.out.println(brand);

        //4释放资源
        sqlSession.close();
    }

    @Test
    public void testselectByCondition() throws IOException {
        //接受参数
        int status = 1;
        String companyName ="华为";
        String brandName ="华为";

        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";


        Brand b = new Brand();
        b.setStatus(status);
        b.setCompanyName(companyName);
        b.setBrandName(brandName);

        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        //map.put("brandName",brandName);

        //1加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取SqlSessionFactory的对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3用Mapper代理的方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands1 = mapper.selectByCondition1(status,companyName,brandName);
        System.out.println("散装参数方法："+brands1);

        List<Brand> brands2 = mapper.selectByCondition2(b);
        System.out.println("对象的方法："+brands2);


        List<Brand> brands3 = mapper.selectByCondition3(map);
        System.out.println("map集合方法："+brands3);

        //4释放资源
        sqlSession.close();
    }

    @Test
    public void testselectByConditionSignal() throws IOException {
        //接受参数
        int status = 1;
        String companyName ="华为";
        String brandName ="华为";

        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";


        Brand b = new Brand();
        b.setStatus(status);
        b.setCompanyName(companyName);
        b.setBrandName(brandName);

        Map map = new HashMap();
        //map.put("status",status);
        //map.put("companyName",companyName);
        map.put("brandName",brandName);

        //1加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取SqlSessionFactory的对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3用Mapper代理的方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByConditionSingal(map);
        System.out.println(brands);


        //4释放资源
        sqlSession.close();
    }

    @Test
    public void testinsert() throws IOException {
        //接受参数
        int status = 1;
        String companyName ="桃李";
        String brandName ="醇熟";
        String description ="健康低脂";
        int order =100;

        //处理参数
        companyName = companyName;
        brandName = brandName;

        Brand b = new Brand();
        b.setStatus(status);
        b.setCompanyName(companyName);
        b.setBrandName(brandName);
        b.setDescription(description);
        b.setOrdered(order);

        //1加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取SqlSessionFactory的对象，用它来执行sql
        //这里设置位true就是自动提交事务
        //如果参数设置为空，会出现：Setting autocommit to false on JDBC Connection
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3用Mapper代理的方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.insertInfo(b);


        Integer id = b.getId();
        System.out.println(id);

        //应用于手动提交的类型，不然一直没有办法更新
        //sqlSession.commit();


        //4释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdateAll() throws IOException {
        //接受参数
        int status = 1;
        String companyName ="桃李";
        String brandName ="手撕面包";
        String description ="奶香十足";
        int order =300;

        Brand b = new Brand(4,brandName,companyName,order,description,status);

        //1加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取SqlSessionFactory的对象，用它来执行sql
        //这里设置位true就是自动提交事务
        //如果参数设置为空，会出现：Setting autocommit to false on JDBC Connection
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3用Mapper代理的方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int row = mapper.updata(b);
        System.out.println(row);

        //4释放资源
        sqlSession.close();


    }

    @Test
    public void testUpdateDynamic() throws IOException {
        //接受参数
        int status = 1;
        String companyName ="友臣";
       // String description ="奶香十足";
        int order =260;

        Brand b = new Brand();
        b.setStatus(status);
        //b.setDescription(description);
        b.setCompanyName(companyName);
        b.setOrdered(order);
        b.setId(13);

        //1加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取SqlSessionFactory的对象，用它来执行sql
        //这里设置位true就是自动提交事务
        //如果参数设置为空，会出现：Setting autocommit to false on JDBC Connection
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3用Mapper代理的方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int row = mapper.updataDynamic(b);
        System.out.println(row);
        //4释放资源
        sqlSession.close();


    }

    @Test
    public void testDelete() throws IOException {
        //接受参数
        int [] ids = {2,4,3};

        //1加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取SqlSessionFactory的对象，用它来执行sql
        //这里设置位true就是自动提交事务
        //如果参数设置为空，会出现：Setting autocommit to false on JDBC Connection
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3用Mapper代理的方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        //4释放资源
        sqlSession.close();


    }


    @Test
    public void testParameter() throws IOException {
        //接受参数
        int status = 1;
        String companyName ="华为";
        String brandName ="华为";

        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";


        Brand b = new Brand();
        b.setStatus(status);
        b.setCompanyName(companyName);
        b.setBrandName(brandName);

        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        //1加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2获取SqlSessionFactory的对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3用Mapper代理的方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
/*        List<Brand> brands1 = mapper.selectByCondition1(status,companyName,brandName);
        System.out.println("散装参数方法："+brands1);

        List<Brand> brands2 = mapper.selectByCondition2(b);
        System.out.println("对象的方法："+brands2);*/


        List<Brand> brands3 = mapper.selectByCondition11(status,companyName,brandName);
        System.out.println(brands3);

        //4释放资源
        sqlSession.close();

    }

}























