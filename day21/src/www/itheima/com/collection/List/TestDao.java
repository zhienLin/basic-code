package www.itheima.com.collection.List;

import java.util.List;

public class TestDao {
    public static void main(String[] args) {
        DAO <TaiDiDog> aDao = new DAO<>();
        TaiDiDog td1 = new TaiDiDog("乐乐",1);
        TaiDiDog td2 = new TaiDiDog("贝贝",1);
        TaiDiDog td3 = new TaiDiDog("壮壮",1);
        aDao.save(td1.getName(),td1);
        aDao.save(td2.getName(),td2);
        aDao.save(td3.getName(),td3);
        TaiDiDog taiDiDog = aDao.get(td3.getName());
        System.out.println(taiDiDog.getName()+"今年"+taiDiDog.getAge()+"岁了。");
        TaiDiDog entity = new TaiDiDog();
        aDao.update(td3.getName(), entity);
        System.out.println(entity.getName()+"今年"+entity.getAge()+"岁了。");
        List<TaiDiDog> list = aDao.list();
        System.out.println(list);
        aDao.delete("乐乐");
        List<TaiDiDog> list1 = aDao.list();
        System.out.println(list1);


    }
}
