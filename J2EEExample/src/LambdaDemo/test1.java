package LambdaDemo;

public class test1 {
    public static void main(String[] args) {
        //原始方法
//        A a = new A() {
//            @Override
//            public void sayHello() {
//                System.out.println("helloWord");
//            }
//        };
        //无参数
//        A a1= ()->{
//            System.out.println("helloWord");
//        };
        //有参数
//        A a2= (id)->{
//            System.out.println("helloWord");
//            return 1;
//        };
        //有参有返回值
//        A a2= (id)->{
//            System.out.println("helloWord");
//            return 1;
//        };
        A a= (id)->{
            System.out.println("helloWord");
        };
        a.sayHello(1);
        //default
        Integer integer1 = a.sayHello1(1);
        System.out.println(integer1);
        //static
        Integer integer2 = A.sayHello2(2);
        System.out.println(integer2);
    }
}

@FunctionalInterface
interface  A{
    public  void sayHello(Integer id);

    public default Integer sayHello1(Integer id){
        return id*5;
    }
    public static Integer sayHello2(Integer id){
        return id*3;
    }
}

