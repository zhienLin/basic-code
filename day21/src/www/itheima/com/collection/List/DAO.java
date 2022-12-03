package www.itheima.com.collection.List;
/*
定义个泛型类DAO<T>，在其中定义一个Map成员变量，Map 的键为String 类型，值为T
        类型。
        分别创建以下方法:
public void save(String id,T entity):保存T类型的对象到 Map成员变量中
public T get(String id): 从 map 中获取id对应的对象
public void update(String id,T entity):替换map 中key为id的内容,改为entity
        对象
public List<T> list():返回map中存放的所有T对象
public void delete(String id):删除指定id 对象
*/

import java.util.*;

public class DAO <T> {
    Map<String,T> map= new HashMap<>();
    public void save(String id,T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id,T entity){
        map.put(id,entity);
    }
    public List<T> list(){
        Collection<T> values = map.values();
        return (List)values;
/*        List<T> list = new ArrayList<>();
        map.forEach((s, t) ->list.add(t));
        return list;*/
    }
    public void delete(String id){
        map.remove(id);
    }
}
