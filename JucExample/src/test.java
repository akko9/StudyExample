public class test {

        public static void main(String[] args)  {
            MyClass myClass1 = new MyClass();
            MyClass myClass2 = new MyClass();
            System.out.println(myClass1.i);
            System.out.println(myClass1.j);
            System.out.println(myClass2.i);
            System.out.println(myClass2.j);

        }

    static class MyClass {
        public static final double i = Math.random();
        public static double j = Math.random();
    }
}
