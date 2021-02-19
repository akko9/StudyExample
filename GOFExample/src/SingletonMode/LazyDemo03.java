package SingletonMode;
/*
懒汉式    问题:同方法一
 */
public class LazyDemo03 {
    public static void main(String[] args) {
        Lazy03 lazy01=Lazy03.getInstance();
        Lazy03 lazy02=Lazy03.getInstance();
        System.out.println(lazy01==lazy02);
    }
}

class Lazy03{
    /*
    私有构造方法
     */
    private Lazy03() {
    }
    private  static  Lazy03 LAZY;

    public  static Lazy03 getInstance(){
        //当一个线程在进行判断,但这时候其他先判断进入,会导致对象重复创建
        if (LAZY==null){
            synchronized (Lazy03.class){
                LAZY=new Lazy03();
            }
        }
        return LAZY;
    }
}