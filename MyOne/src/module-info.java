import www.itheima.com03.MyService;
import www.itheima.com03.impl.ChuanZhi;
import www.itheima.com03.impl.ITheima;

module MyOne {
    exports www.itheima.com01;
    exports www.itheima.com02;
    exports www.itheima.com03;
    provides MyService with ITheima, ChuanZhi;//指定MyService的服务实现类是ITheima，服务的配置模块才指定了具体应该实现哪个类
}