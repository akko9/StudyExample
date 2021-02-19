package SingletonMode;
/*
懒汉式 方法6:枚举

 */
public class LazyDemo06 {
    public static void main(String[] args) {
        Lazy06 lazy01=Lazy06.INSTANCE;
        Lazy06 lazy02=Lazy06.INSTANCE;
        lazy01.sayOk();
        System.out.println(lazy01==lazy02);
    }
}

enum Lazy06{
    INSTANCE;

    public void sayOk(){
        System.out.println("okokok");
    }

}