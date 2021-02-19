package ProxyMode.StaticProxy;

public class Client {
    public static void main(String[] args) {
        TeacherProxy teacherProxy=new TeacherProxy(new Teacher());
        teacherProxy.run();
    }
}
