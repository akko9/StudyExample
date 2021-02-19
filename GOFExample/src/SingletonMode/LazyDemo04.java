package SingletonMode;
/*
懒汉式 方法4:双重检测: 解决线程+效率问题

 */
public class LazyDemo04 {
    public static void main(String[] args) {
        Lazy04 lazy01=Lazy04.getInstance();
        Lazy04 lazy02=Lazy04.getInstance();
        System.out.println(lazy01==lazy02);
    }
}

class Lazy04{
    /*
    私有构造方法
     */
    private Lazy04() {
    }
    private  static volatile Lazy04 LAZY; //防止指令重排

    public static Lazy04 getInstance(){
        //当一个线程在进行判断,但这时候其他先判断进入,会导致对象重复创建
        if (LAZY==null){
            synchronized (Lazy04.class){
                //当另一个线程进入会进行判断
                if (LAZY==null){
                    LAZY=new Lazy04();
                }
            }
        }
        return LAZY;
    }
}