package SingletonMode;
/*
懒汉式 方法二:线程不安全 加入synchronized
        优:效率低 getInstance其实只要执行一次就行了
        缺:解决线程不安全问题
 */
public class LazyDemo02 {
    public static void main(String[] args) {
        Lazy02 lazy01=Lazy02.getInstance();
        Lazy02 lazy02=Lazy02.getInstance();
        System.out.println(lazy01==lazy02);
    }
}

class Lazy02{
    /*
    私有构造方法
     */
    private Lazy02() {
    }
    private  static  Lazy02 LAZY;

    public synchronized static Lazy02 getInstance(){
        //当一个线程在进行判断,但这时候其他先判断进入,会导致对象重复创建
        if (LAZY==null){
            LAZY=new Lazy02();
        }
        return LAZY;
    }
}