package SingletonMode;

/*
饿汉式  优点:方法简单,无多线程问题
       缺点:内存浪费
 */
public class HungryDemo02 {
    public static void main(String[] args) {
        Hungry02 hungry1=Hungry02.getInstance();
        Hungry02 hungry2=Hungry02.getInstance();
        System.out.println(hungry1==hungry2);
    }

}

class Hungry02{
    /*
    创建一个对象实例
     */
    private static Hungry02 HUNGRY;
    /*
    构造器私有化
     */
    private Hungry02() {
    }
    /*
    静态代码块创建对象
     */
    static {
        HUNGRY=new Hungry02();
    }
    /*
    开放一个方法得到实例
     */
    public static Hungry02 getInstance(){
        return HUNGRY;
    }
}
