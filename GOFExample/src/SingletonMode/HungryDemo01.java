package SingletonMode;

/*
饿汉式  优点:方法简单,无多线程问题
       缺点:内存浪费
 */
public class HungryDemo01 {
    public static void main(String[] args) {
        Hungry01 hungry1=Hungry01.getInstance();
        Hungry01 hungry2=Hungry01.getInstance();
        System.out.println(hungry1==hungry2);
    }

}
class Hungry01{
    /*
    创建一个对象实例
     */
    private static final Hungry01 HUNGRY=new Hungry01();
    /*
    构造器私有化
     */
    private Hungry01() {
    }
    /*
    开放一个方法得到实例
     */
    public static Hungry01 getInstance(){
        return HUNGRY;
    }
}
