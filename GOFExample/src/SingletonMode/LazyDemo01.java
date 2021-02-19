package SingletonMode;
/*
懒汉式 方法一:线程不安全

 */
public class LazyDemo01 {
    public static void main(String[] args) {
        Lazy01 lazy01=Lazy01.getInstance();
        Lazy01 lazy02=Lazy01.getInstance();
        System.out.println(lazy01==lazy02);
    }
}
class Lazy01{
    /*
    私有构造方法
     */
    private Lazy01() {
    }
    private  static  Lazy01 LAZY;

    public static Lazy01 getInstance(){
        //当一个线程在进行判断,但这时候其他先判断进入,会导致对象重复创建
        if (LAZY==null){
            LAZY=new Lazy01();
        }
        return LAZY;
    }
}