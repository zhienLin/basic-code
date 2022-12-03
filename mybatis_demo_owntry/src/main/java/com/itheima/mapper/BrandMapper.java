package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zzy
 * @date 2022-11-10 10:58
 */
public interface BrandMapper {

   /*1查询所有*/
   List<Brand> selectAll();
   /*2根据id查询*/
   Brand selectByIdBrand(int id);

   /*条件查询
   * 方式一： 散装参数,如果方法中有多个参数，需要使用@Param
   * 方式二： 对象参数
   * 方式三： Map集合参数
   *
   * */
   List<Brand> selectByCondition1(@Param("status") int status,
                                 @Param("companyName") String companyName,
                                 @Param("brandName") String brandName);


   /* MyBatis参数封装:
      *单个参数:
      1.POJ0类型:直接使用，属性名和参数占位符名称一致
      2. Map集合:直接使用，键名和参数占位符名称一致
      3. Collection:封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
                    map.put( "arg0 " , collection集合);
                    map.put("collection" , collection集合);
      4. List:封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
                    map.put( "arg0" ,list集合);
                    map .put("collection" ,list集合);map.put( "list" ,list集合);
      5. Array:封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
                    map . put( "arg0"，数组);
                    map .put( "array "，数组);6．其他类型:直接使用
      *多个参数:封装为Map集合,可以使用@Param注解，替换Map集合中默认的arg键名
                    map.put("arg0"，参数值1)
                    map.put("param1"，参数值1)
                    map.put("param2"，参数值2)
                    map.put("agr1"，参数值2)
*/
   List<Brand> selectByCondition11(int status,
                                   String companyName,
                                   String brandName);

   List<Brand> selectByCondition2(Brand b );
   List<Brand> selectByCondition3(Map map);

   /*单条件查询*/
   List<Brand> selectByConditionSingal(Map map);

   /*插入*/
   void insertInfo(Brand b);


   /*修改全部字段*/
   int updata(Brand b);

   /*修改动态的某些字段*/
   int updataDynamic(Brand b);

   /*根据id批量删除*/

   void deleteByIds(@Param("ids") int ids []);


}
