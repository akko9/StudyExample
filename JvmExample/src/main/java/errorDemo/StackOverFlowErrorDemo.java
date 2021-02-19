package errorDemo;

public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        StackOverFlowErrorOperation();
    }

    private static void StackOverFlowErrorOperation() {
        StackOverFlowErrorOperation(); //Exception in thread "main" java.lang.StackOverflowError
    }
}
