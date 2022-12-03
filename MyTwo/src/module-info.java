import www.itheima.com03.MyService;

module MyTwo {
    requires MyOne;
    uses MyService;//在这个模块下，其实并不知道MyService的实现类接口是什么，只是知道可以使用这个接口
}