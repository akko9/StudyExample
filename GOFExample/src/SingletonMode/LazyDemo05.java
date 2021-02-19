package SingletonMode;
/*
懒汉式 方法5:静态内部类
当类加载时,静态内部类不会被加载,调用时才加载，并且线程安全
在类的初始化时,其他线程无法进入
 */
public class LazyDemo05 {
    public static void main(String[] args) {
        Lazy05 lazy01=Lazy05.getInstance();
        Lazy05 lazy02=Lazy05.getInstance();
        System.out.println(lazy01==lazy02);
    }
}

class Lazy05{
    /*
    私有构造方法
     */
    private Lazy05() {
    }
    /*
    构建静态内部类
     */
    private static class InnerLazy{
        private static final  Lazy05 LAZY=new Lazy05();
    }
    public static Lazy05 getInstance(){
        return InnerLazy.LAZY;
    }
}